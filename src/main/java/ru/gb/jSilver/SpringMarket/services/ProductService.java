package ru.gb.jSilver.SpringMarket.services;

import org.springframework.stereotype.Service;
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
}
