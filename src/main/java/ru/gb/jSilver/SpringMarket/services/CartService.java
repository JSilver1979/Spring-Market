package ru.gb.jSilver.SpringMarket.services;

import org.springframework.stereotype.Service;
import ru.gb.jSilver.SpringMarket.data.Cart;
import ru.gb.jSilver.SpringMarket.dto.ProductListDto;

import java.util.List;

@Service
public class CartService {

    private final Cart cart;
    private final ProductService productService;

    public CartService(Cart cart, ProductService productService) {
        this.cart = cart;
        this.productService = productService;
    }

    public List<ProductListDto> getAllFromCart() {
        return cart.getCartList();
    }

    public void addToCart(Long id) {
        cart.addProduct(productService.findByListId(id));
    }

    public void removeFromCart (Long id) {
        cart.removeProduct(productService.findByListId(id));
    }
}
