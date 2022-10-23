package ru.gb.jSilver.SpringMarket.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.jSilver.SpringMarket.dto.Product;
import ru.gb.jSilver.SpringMarket.repos.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Transactional
    public void changeProductPrice(Long productId, Integer price) {
        Product product = productRepository.findById(productId).orElseThrow();
        product.setPrice(product.getPrice() + price);
        productRepository.save(product);
    }
}
