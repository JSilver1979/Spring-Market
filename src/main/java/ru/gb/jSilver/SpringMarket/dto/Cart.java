package ru.gb.jSilver.SpringMarket.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class Cart {
    private List<CartItemDto> cartItems;
    private Integer totalPrice;

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    public List<CartItemDto> getItems() {
        return Collections.unmodifiableList(cartItems);
    }

    public void add(ProductDto productDto) { // TODO: доработать чтобы продукты суммировались
        cartItems.add(new CartItemDto(
                productDto.getId(),
                productDto.getTitle(),
                1,
                productDto.getPrice(),
                productDto.getPrice()));
        recalculate();
    }

    private void recalculate () {
        totalPrice = 0;
        for (CartItemDto item:
             cartItems) {
            totalPrice += item.getPrice();
        }
    }
}
