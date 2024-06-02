package ru.diszexuf.webshop.service.Impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.diszexuf.webshop.model.Product;
import ru.diszexuf.webshop.repository.IProductRepository;
import ru.diszexuf.webshop.service.IProductService;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class ProductService implements IProductService {
    private final IProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findByModel(String title) {
        return productRepository.findByTitle(title);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public void deleteProductByModel(String title) {
        productRepository.deleteByTitle(title);
    }
}
