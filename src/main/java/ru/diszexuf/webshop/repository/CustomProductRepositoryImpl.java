package ru.diszexuf.webshop.repository;

import jakarta.persistence.EntityManager;
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

        Root<Product> productRoot = query.from(Product.class);
        Join<Product, ProductSpecifications> psJoin = productRoot.join("product_pkey", JoinType.INNER);

        query.select(productRoot)
                .distinct(true);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(productRoot.get("category").get("id"), 1));

        for (Map.Entry<Integer, List<String>> entry : specifications.entrySet()) {
            Integer specificationId = entry.getKey();
            List<String> values = entry.getValue();

            Expression<Integer> specificationIdExpression = cb.literal(specificationId);
            Path<String> valuePath = psJoin.get("value");
            Path<Integer> specificationIdPath = psJoin.get("specifications_id");

            List<Predicate> orPredicates = new ArrayList<>();
            for (String value : values) {
                Expression<String> valueExpression = cb.literal(value);
                Predicate specificationPredicate = cb.and(
                        cb.equal(specificationIdPath, specificationIdExpression),
                        cb.equal(valuePath, valueExpression)
                );
                orPredicates.add(specificationPredicate);
            }

            predicates.add(cb.or(orPredicates.toArray(new Predicate[0])));
        }

        query.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }


}
