package ru.diszexuf.webshop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;
import ru.diszexuf.webshop.model.Product;
import ru.diszexuf.webshop.model.ProductSpecifications;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CustomProductRepositoryImpl implements CustomProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAllProducts(String categoryId, Map<Integer, List<String>> specifications) {
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

        query.select(product).distinct(true).where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }


}
