package ru.diszexuf.webshop.service;

import ru.diszexuf.webshop.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> findAllProducts(String categoryId, Map<String, String> params, String minPrice, String maxPrice);
    Product saveProduct(Product product);
    Product findByModel(String title);
    Product updateProduct(Product product);
    void deleteProductByModel(String title);
}
