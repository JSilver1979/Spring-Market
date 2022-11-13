package ru.gb.jSilver.SpringMarket.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.jSilver.SpringMarket.converters.ProductMapper;
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
        return productRepository.findById(id).map(ProductMapper.MAPPER::fromProduct).orElseThrow();
    }

    public List<ProductListDto> findAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper.MAPPER::fromProductToListDto)
                .collect(Collectors.toList());
    }


    public void deleteProduct(Long id) {
        DeleteProductDto deleteProductDto = new DeleteProductDto(id);
        productRepository.deleteById(deleteProductDto.getId());
    }

    public void createProduct(CreateProductDto product) {
        productRepository.save(ProductMapper.MAPPER.toProductFromCreateDto(product));
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
