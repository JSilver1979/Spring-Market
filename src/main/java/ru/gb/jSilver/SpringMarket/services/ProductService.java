package ru.gb.jSilver.SpringMarket.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.jSilver.SpringMarket.dto.Product;
import ru.gb.jSilver.SpringMarket.repos.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product getProductById (Integer id) {
        return productRepository.findByID(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public void changePrice(Integer id, Double price) {
        Product product = productRepository.findByID(id);
        product.setPrice(product.getPrice() + price);
    }

    public void deleteProduct(Integer productId) {
        Product product = productRepository.findByID(productId);
        productRepository.deleteProduct(product);
    }
}
