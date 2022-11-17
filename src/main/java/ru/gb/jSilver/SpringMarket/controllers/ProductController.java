package ru.gb.jSilver.SpringMarket.controllers;

import org.springframework.web.bind.annotation.*;
import ru.gb.jSilver.SpringMarket.dto.CreateProductDto;
import ru.gb.jSilver.SpringMarket.dto.ProductDto;
import ru.gb.jSilver.SpringMarket.dto.ProductListDto;
import ru.gb.jSilver.SpringMarket.dto.UpdateProductDto;
import ru.gb.jSilver.SpringMarket.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<ProductListDto> getProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PutMapping("/update")
    public void updateProduct(@RequestBody UpdateProductDto product) {
        productService.updateProduct(product);
    }

    @GetMapping ("/change_price")
    public void changeProductPrice(@RequestParam Long productId, @RequestParam Integer price) {
        productService.changeProductPrice(productId, price);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @PostMapping()
    public void addProduct(@RequestBody CreateProductDto product) {
        productService.createProduct(product);
    }
}
