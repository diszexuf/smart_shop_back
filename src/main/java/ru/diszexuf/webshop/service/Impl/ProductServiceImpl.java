package ru.diszexuf.webshop.service.Impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.diszexuf.webshop.model.Product;
import ru.diszexuf.webshop.model.ProductSpecifications;
import ru.diszexuf.webshop.model.Specifications;
import ru.diszexuf.webshop.repository.CategoryRepository;
import ru.diszexuf.webshop.repository.IProductRepository;
import ru.diszexuf.webshop.repository.IProductSpecificationsRepository;
import ru.diszexuf.webshop.repository.SpecificationsRepository;
import ru.diszexuf.webshop.service.ProductService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final IProductRepository productRepository;
    private final SpecificationsRepository specificationsRepository;
    private final IProductSpecificationsRepository productSpecificationsRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<Product> findAllProducts(String categoryId, Map<String, String> params, String minPrice, String maxPrice) {
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

        return productRepository.findAllProducts(categoryId, specifications, minPrice, maxPrice);
    }

    @Override
    public Product saveProduct(Product product, Map<String, String> specs, MultipartFile image, Long categoryId) {

        String imagePath = saveImage(image);
        product.setImage(imagePath);
        product.setCategory(categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("User not found")));

        Product savedProduct = productRepository.save(product);

        for (Map.Entry<String, String> spec : specs.entrySet()) {
            if (specificationsRepository.findByTitle(spec.getKey()) == null ) {
                Specifications newSpec = new Specifications();
                newSpec.setTitle(spec.getKey());
                specificationsRepository.save(newSpec);
            }
            ProductSpecifications productSpecifications = new ProductSpecifications();
            productSpecifications.setProduct(savedProduct);
            productSpecifications.setSpecifications(specificationsRepository.findByTitle(spec.getKey()));
            productSpecifications.setValue(spec.getValue());

            productSpecificationsRepository.save(productSpecifications);
        }

        return savedProduct;
    }

    private String saveImage(MultipartFile image) {
        try {
            String uploadDir = System.getProperty("user.dir") + "/uploads/";
            String fileName = image.getOriginalFilename();
            Path path = Paths.get(uploadDir + fileName);

            if (!Files.exists(path.getParent())) {
                Files.createDirectories(path.getParent());
            }

            Files.copy(image.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            return "/uploads/" + fileName;
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при сохранении файла", e);
        }
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

    @Override
    public Map<String, String> getSpecificationOfProduct(Long productId) {
        return productRepository.getSpecificationOfProduct(productId);
    }
}
