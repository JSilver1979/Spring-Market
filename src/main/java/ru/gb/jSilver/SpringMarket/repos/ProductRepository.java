package ru.gb.jSilver.SpringMarket.repos;

import org.springframework.stereotype.Repository;
import ru.gb.jSilver.SpringMarket.dto.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<>(Arrays.asList(
                new Product(1,"Apple", 99.00),
                new Product(2, "Orange", 299.99),
                new Product(3, "Carrot", 90.50),
                new Product(4,"Cheese", 200.7)
        ));
    }

    public Product findByID(Integer id) {
        return productList.stream().filter(product ->
                product.getId().equals(id)).findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public void deleteProduct(Product product) {
        productList.remove(product);
    }
}
