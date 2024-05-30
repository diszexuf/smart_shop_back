package ru.diszexuf.webshop.repository;

import org.springframework.stereotype.Repository;
import ru.diszexuf.webshop.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryProductDAO {
    private final List<Product> PRODUCTS = new ArrayList<Product>();

    public Product saveProduct(Product product) {
        PRODUCTS.add(product);
        return product;
    }

    public Product findByName(String name) {
        return PRODUCTS.stream().filter(elem -> elem.getModel().
                equals(name)).findFirst().orElse(null);
    }

    public Product updateProduct(Product product) {
        var firstIndex = IntStream.range(0, PRODUCTS.size()).
                filter(i -> PRODUCTS.get(i).getModel().
                        equals(product.getModel())).
                findFirst().orElse(-1);

        if (firstIndex != -1) {
            PRODUCTS.set(firstIndex, product);
        }
        return null;
    }

    public void deleteProduct(String name) {
        var product = findByName(name);
        if (product != null) {
            PRODUCTS.remove(product);
        }
    }

    public List<Product> findAllProducts() {
        return PRODUCTS;
    }
}
