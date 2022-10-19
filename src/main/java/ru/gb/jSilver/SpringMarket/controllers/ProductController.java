package ru.gb.jSilver.SpringMarket.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.jSilver.SpringMarket.dto.Product;
import ru.gb.jSilver.SpringMarket.services.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("products/{id}")
    public Optional<Product> getProduct(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("products/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @PostMapping("products")
    public void addProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }
}
