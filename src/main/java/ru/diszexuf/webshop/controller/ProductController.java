package ru.diszexuf.webshop.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.diszexuf.webshop.dto.SpecificationAggregationDTO;
import ru.diszexuf.webshop.model.Product;
import ru.diszexuf.webshop.service.ProductService;
import ru.diszexuf.webshop.service.Impl.ProductSpecificationsService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @Autowired
    private ProductSpecificationsService productSpecificationsService;

    @PostMapping("/save_product")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/{title}")
    public Product findByTitle(@PathVariable String title) {
        return productService.findByModel(title);
    }

    @PutMapping("/update_product")
    public Product updateProduct(Product product) {
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

    @GetMapping("/filters")
    public List<SpecificationAggregationDTO> getSpecificationsAggregationByCategoryId(Long categoryId) {
        return productSpecificationsService.getSpecificationsAggregationByCategoryId(categoryId);
    }

}
