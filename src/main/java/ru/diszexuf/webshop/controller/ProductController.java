package ru.diszexuf.webshop.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.diszexuf.webshop.dto.SpecificationAggregationDTO;
import ru.diszexuf.webshop.model.Product;
import ru.diszexuf.webshop.model.ProductSpecifications;
import ru.diszexuf.webshop.service.ProductService;
import ru.diszexuf.webshop.service.Impl.ProductSpecificationsService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    private ProductSpecificationsService productSpecificationsService;

    @PostMapping("/save_product")
    public ResponseEntity<Product> saveProduct(@RequestPart("product") Product product,
                                               @RequestPart("specs") Map<String, String> specs,
                                               @RequestPart("image") MultipartFile image,
                                               @RequestParam("categoryId") Long categoryId) {
        Product savedProduct = productService.saveProduct(product, specs, image, categoryId);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping("/{title}")
    public Product findByTitle(@PathVariable String title) {
        return productService.findByModel(title);
    }

    @PutMapping("/update_product")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete_product/{title}")
    public void deleteProduct(@PathVariable String title) {
        productService.deleteProductByModel(title);
    }

    @GetMapping("/all_products")
    public List<Product> findAllProducts(
        @RequestParam String categoryId,
        @RequestParam Map<String, String> params,
        @RequestParam String minPrice,
        @RequestParam String maxPrice
    ) {
        return productService.findAllProducts(categoryId, params, minPrice, maxPrice);
    }

    @GetMapping("/specs_{productId}")
    public Map<String, String> getSpecificationOfProduct(@PathVariable Long productId) {
        return productService.getSpecificationOfProduct(productId);
    }

    @GetMapping("/filters")
    public List<SpecificationAggregationDTO> getSpecificationsAggregationByCategoryId(Long categoryId) {
        return productSpecificationsService.getSpecificationsAggregationByCategoryId(categoryId);
    }

}
