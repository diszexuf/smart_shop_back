package ru.diszexuf.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.diszexuf.webshop.model.Product;

public interface IProductRepository extends JpaRepository<Product, Long>, CustomProductRepository {
    Product findByTitle(String title);

    void deleteByTitle(String title);

//    @Query(value = "select distinct p.id, p.image, p.title, p.category_id " +
//            "from product_specifications ps " +
//            "join product p ON p.id = ps.product_id " +
//            "where p.category_id = 1 and" +
//            " (" +
//            " (ps.specifications_id = 1 and ps.value = '3')" +
//            " or (ps.specifications_id = 1 and ps.value = '4')" +
//            " or (ps.specifications_id = 4 and ps.value = 'Apple')" +
//            " )",
//            nativeQuery = true)
//    List<Product> findAllProducts(String categoryId, Map<Integer, List<String>> specifications);
}

/* CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> query = cb.createQuery(Product.class);
        Root<Product> product = query.from(Product.class);
        Join<Object, Object> productSpecifications = product.join("productSpecifications");

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(product.get("categoryId"), categoryId));

        List<Predicate> specificationsPredicates = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : specifications.entrySet()) {
            Integer specificationId = entry.getKey();
            List<String> specificationValues = entry.getValue();
            for(String specificationValue : specificationValues) {
                specificationsPredicates.add(cb.and(
                        cb.equal(productSpecifications.get("specificationId"), specificationId),
                        cb.equal(productSpecifications.get("value"), specificationValue)
                ));
            }
        }

        if(!specificationsPredicates.isEmpty()) {
            predicates.add(cb.or(specificationsPredicates.toArray(new Predicate[0])));
        }

        query.select(product).distinct(true).where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();*/
