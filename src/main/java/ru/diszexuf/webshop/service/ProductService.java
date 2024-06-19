package ru.diszexuf.webshop.service;

import org.springframework.web.multipart.MultipartFile;
import ru.diszexuf.webshop.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> findAllProducts(String categoryId, Map<String, String> params, String minPrice, String maxPrice);
    Product saveProduct(Product product, Map<String, String> specs, MultipartFile image, Long categoryId, Long id);
    Product findByTitle(String title);
    Product findById(Long id);
    Product updateProduct(Product product);
    void deleteProductById(Long productId);
    Map<String, String> getSpecificationOfProduct(Long productId);
}
