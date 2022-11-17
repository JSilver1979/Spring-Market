package ru.gb.jSilver.SpringMarket.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.jSilver.SpringMarket.data.Product;
import ru.gb.jSilver.SpringMarket.dto.*;
import ru.gb.jSilver.SpringMarket.repos.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDto findById(Long id) {
        return productRepository.findById(id).map(product -> new ProductDto(product)).orElseThrow();
    }

    public ProductListDto findByListId(Long id) {
        return productRepository.findById(id).map(product -> new ProductListDto(product)).orElseThrow();
    }

    public List<ProductListDto> findAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductListDto(product))
                .collect(Collectors.toList());
    }


    public void deleteProduct(Long id) {
        DeleteProductDto deleteProductDto = new DeleteProductDto(id);
        productRepository.deleteById(deleteProductDto.getId());
    }

    public void createProduct(CreateProductDto product) {
        productRepository.save(new Product(product.getTitle(), product.getPrice()));
    }

    @Transactional
    public void changeProductPrice(Long productId, Integer price) {
        ChangeProductPriceDto productChangedPrice = new ChangeProductPriceDto(productId, price);
        Product product = productRepository.findById(productChangedPrice.getId()).orElseThrow();
        product.setPrice(product.getPrice() + productChangedPrice.getPrice());
        productRepository.save(product);
    }

    @Transactional
    public void updateProduct(UpdateProductDto product) {
        Product updatedProduct = productRepository.findById(product.getId()).orElseThrow();
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setTitle(product.getTitle());
        productRepository.save(updatedProduct);
    }
}
