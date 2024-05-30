package ru.diszexuf.webshop.service;

import ru.diszexuf.webshop.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAllProducts();
    Product saveProduct(Product product);
    Product findByModel(String model);
    Product updateProduct(Product product);
    void deleteProductByModel(String model);
}
