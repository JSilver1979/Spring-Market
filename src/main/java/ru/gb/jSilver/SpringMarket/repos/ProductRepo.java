package ru.gb.jSilver.SpringMarket.repos;

import org.springframework.stereotype.Repository;
import ru.gb.jSilver.SpringMarket.dto.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepo {
    private List<Product> productList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<>(Arrays.asList(
                new Product(1,"Apple", 100.00),
                new Product(2, "Orange", 200.00),
                new Product(3, "GrapeFruit", 249.99),
                new Product(4, "Pineapple", 319.90)
        ));
    }

    public Product findByID(Integer id) {
        return productList.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public List<Product> getProductList() {
        return productList;
    }
}
