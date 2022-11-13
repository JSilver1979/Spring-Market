package ru.gb.jSilver.SpringMarket.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.jSilver.SpringMarket.converters.ProductMapper;
import ru.gb.jSilver.SpringMarket.data.Cart;
import ru.gb.jSilver.SpringMarket.dto.ProductDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {

    private final Cart cart;
    private final ProductService productService;

    public CartService(Cart cart, ProductService productService) {
        this.cart = cart;
        this.productService = productService;
    }

    public List<ProductDto> getAllFromCart() {
        return cart.getCartList()
                .stream()
                .map(ProductMapper.MAPPER::fromProduct)
                .collect(Collectors.toList());
    }

    public void addToCart(Long id) {
        ProductDto product = productService.findById(id);
        cart.addProduct(ProductMapper.MAPPER.toProductFromDto(product));
    }

    public void removeFromCart (Long id) {
        ProductDto product = productService.findById(id);
        cart.removeProduct(ProductMapper.MAPPER.toProductFromDto(product));
    }
}
