package ru.diszexuf.webshop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;
import ru.diszexuf.webshop.model.Product;
import ru.diszexuf.webshop.model.ProductSpecifications;
import ru.diszexuf.webshop.model.Specifications;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomProductRepositoryImpl implements CustomProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAllProducts(String categoryId, Map<Integer, List<String>> specifications, String minPrice, String maxPrice) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> query = cb.createQuery(Product.class);
        Root<Product> product = query.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();

        if (categoryId != null) {
            predicates.add(cb.equal(product.get("category").get("id"), categoryId));
        }

        if (specifications != null && !specifications.isEmpty()) {
            List<Predicate> subqueryPredicates = new ArrayList<>();

            for (Map.Entry<Integer, List<String>> entry : specifications.entrySet()) {
                Integer specId = entry.getKey();
                List<String> values = entry.getValue();

                Subquery<Long> subquery = query.subquery(Long.class);
                Root<ProductSpecifications> productSpec = subquery.from(ProductSpecifications.class);
                subquery.select(productSpec.get("product").get("id"))
                        .where(cb.and(
                                cb.equal(productSpec.get("specifications").get("id"), specId),
                                productSpec.get("value").in(values)
                        ));

                subqueryPredicates.add(cb.in(product.get("id")).value(subquery));
            }

            predicates.add(cb.or(subqueryPredicates.toArray(new Predicate[0])));
        }

        if (minPrice != null && !minPrice.isEmpty()) {
            double min = Double.parseDouble(minPrice);
            predicates.add(cb.greaterThanOrEqualTo(product.get("price"), min));

        }

        if (maxPrice != null && !maxPrice.isEmpty()) {
            double max = Double.parseDouble(maxPrice);
            predicates.add(cb.lessThanOrEqualTo(product.get("price"), max));
        }

        query.select(product).distinct(true).where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Map<String, String> getSpecificationOfProduct(Long productId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<ProductSpecifications> productSpecRoot = cq.from(ProductSpecifications.class);
        Join<ProductSpecifications, Specifications> specificationsJoin = productSpecRoot.join("specifications");

        cq.multiselect(specificationsJoin.get("title"), productSpecRoot.get("value"))
                .where(cb.equal(productSpecRoot.get("product").get("id"), productId));

        List<Object[]> results = entityManager.createQuery(cq).getResultList();

        Map<String, String> specificationsMap = new HashMap<>();
        for (Object[] result : results) {
            String title = (String) result[0];
            String value = (String) result[1];
            specificationsMap.put(title, value);
        }

        return specificationsMap;
    }


}
