package ru.diszexuf.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.diszexuf.webshop.model.Product;

public interface IProductRepository extends JpaRepository<Product, Long>, CustomProductRepository {
    Product findByTitle(String title);
    void deleteByTitle(String title);
}

