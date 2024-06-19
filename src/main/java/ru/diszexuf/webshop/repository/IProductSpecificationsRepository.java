package ru.diszexuf.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.diszexuf.webshop.model.ProductSpecifications;


import java.util.List;

public interface IProductSpecificationsRepository extends JpaRepository<ProductSpecifications, Long> {

    @Query(value = "select product_specifications.specifications_id, " +
            "specifications.title, " +
            "array_agg(distinct product_specifications.value) values " +
            "from product_specifications " +
            "join product ON product.id = product_specifications.product_id " +
            "join specifications on product_specifications.specifications_id = specifications.id " +
            "where product.category_id = :categoryId " +
            "group by product_specifications.specifications_id, specifications.title",
            nativeQuery = true)
    List<Object[]> findSpecificationsAggregationByCategoryId(@Param("categoryId") Long categoryId);

    void deleteProductSpecificationsByproductId(@Param("productId") Long productId);
}



