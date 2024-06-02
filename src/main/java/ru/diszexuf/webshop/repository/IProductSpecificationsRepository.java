package ru.diszexuf.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.diszexuf.webshop.dto.SpecificationAggregationDTO;
import ru.diszexuf.webshop.model.ProductSpecifications;


import java.util.List;

public interface IProductSpecificationsRepository extends JpaRepository<ProductSpecifications, Long> {

    @Query(value = "select product_specifications.specifications_id, " +
            "specifications.title, " +
            "array_agg(product_specifications.value) values, " +
            "array_agg(product_specifications.product_id) product_ids " +
            "from product_specifications " +
            "join product ON product.id = product_specifications.product_id " +
            "join specifications on product_specifications.specifications_id = specifications.id " +
            "where product.category_id = :categoryId " +
            "group by product_specifications.specifications_id, specifications.title",
            nativeQuery = true)
    List<Object[]> findSpecificationsAggregationByCategoryId(@Param("categoryId") Long categoryId);
}



