package ru.diszexuf.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.diszexuf.webshop.model.Product;

import java.util.List;
import java.util.Map;

public interface IProductRepository extends JpaRepository<Product, Long> {
    Product findByTitle(String title);
    void deleteByTitle(String title);

    @Query(value = "select distinct p.id, p.image, p.title, p.category_id " +
            "from product_specifications ps " +
            "join product p ON p.id = ps.product_id " +
            "where p.category_id = 1 and" +
            " (" +
            " (ps.specifications_id = 1 and ps.value = '3')" +
            " or (ps.specifications_id = 1 and ps.value = '4')" +
            " or (ps.specifications_id = 4 and ps.value = 'Apple')" +
            " )",
            nativeQuery = true)
    List<Product> findAllProducts(String categoryId, Map<Integer, List<String>> specifications);
}
