package ru.gb.jSilver.SpringMarket.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.jSilver.SpringMarket.dto.Product;
import ru.gb.jSilver.SpringMarket.repos.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepository;

    public Product getProductByID (Integer id) {
        return repo.findByID(id);
    }

    public List<Product> getAllProducts() {
        return repo.getProductList();
    }
}
