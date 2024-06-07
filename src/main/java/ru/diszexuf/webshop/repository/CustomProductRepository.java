package ru.diszexuf.webshop.repository;

import ru.diszexuf.webshop.model.Product;

import java.util.List;
import java.util.Map;

public interface CustomProductRepository {
    List<Product> findAllProducts(String categoryId, Map<Integer, List<String>> specifications, String minPrice, String maxPrice);
}
