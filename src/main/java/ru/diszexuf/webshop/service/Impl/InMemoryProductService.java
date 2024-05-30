package ru.diszexuf.webshop.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.diszexuf.webshop.model.Product;
import ru.diszexuf.webshop.repository.InMemoryProductDAO;
import ru.diszexuf.webshop.service.IProductService;

import java.util.List;

@Service
@AllArgsConstructor
public class InMemoryProductService implements IProductService {

    private final InMemoryProductDAO inMemoryProductDAO;

    @Override
    public Product saveProduct(Product product) {
        return inMemoryProductDAO.saveProduct(product);
    }

    @Override
    public Product findByModel(String model) {
        return inMemoryProductDAO.findByName(model);
    }

    @Override
    public Product updateProduct(Product product) {
        return inMemoryProductDAO.updateProduct(product);
    }

    @Override
    public void deleteProductByModel(String model) {
        inMemoryProductDAO.deleteProduct(model);
    }

    @Override
    public List<Product> findAllProducts() {
        return inMemoryProductDAO.findAllProducts();
    }
}
