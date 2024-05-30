package ru.diszexuf.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.diszexuf.webshop.model.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {
    Product findByModel(String model);
    void deleteByModel(String model);
}
