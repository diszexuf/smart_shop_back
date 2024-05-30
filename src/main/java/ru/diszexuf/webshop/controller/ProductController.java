package ru.diszexuf.webshop.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.diszexuf.webshop.model.Product;
import ru.diszexuf.webshop.service.IProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {

    private final IProductService productService;

    @PostMapping("save_product")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/{name}")
    public Product findByName(@PathVariable String name) {
        return productService.findByModel(name);
    }

    @PutMapping("update_product")
    public Product updateProduct(Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("delete_product/{name}")
    public void deleteProduct(@PathVariable String name) {
        productService.deleteProductByModel(name);
    }

    @GetMapping("/all")
    public List<Product> findAllProducts() {
        return productService.findAllProducts();
    }

}
