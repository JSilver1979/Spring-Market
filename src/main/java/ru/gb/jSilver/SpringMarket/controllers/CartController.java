package ru.gb.jSilver.SpringMarket.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.jSilver.SpringMarket.dto.ProductDto;
import ru.gb.jSilver.SpringMarket.services.CartService;

import java.util.List;

@RestController
@RequestMapping("api/v1/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping()
    public List<ProductDto> showCart() {
        return cartService.getAllFromCart();
    }

    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id) {
        cartService.addToCart(id);
    }

    @GetMapping("/remove/{id}")
    public void removeFromCart(@PathVariable Long id) {
        cartService.removeFromCart(id);
    }
}
