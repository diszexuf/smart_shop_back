package ru.diszexuf.webshop.service.Impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.diszexuf.webshop.model.Product;
import ru.diszexuf.webshop.repository.IProductRepository;
import ru.diszexuf.webshop.service.IProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    @Override
    public List<Product> findAllProducts(String categoryId, Map<String, String> params) {
        Map<Integer, List<String>> specifications = new HashMap<>();

        params.forEach((key, value) -> {
            if(!key.contains("specifications[")) {
                return;
            }
            String regex = "\\[(\\d+)\\]\\[\\d+\\]";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(key);
            if (matcher.find()) {
                int extractedNumber = Integer.parseInt(matcher.group(1));
                if (!specifications.containsKey(extractedNumber)) {
                    specifications.put(extractedNumber, new ArrayList<>());
                }
                specifications.get(extractedNumber).add(value);
            }
        });

        return productRepository.findAllProducts(categoryId, specifications);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

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
