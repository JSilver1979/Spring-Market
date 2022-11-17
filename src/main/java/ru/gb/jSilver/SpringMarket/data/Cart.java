package ru.gb.jSilver.SpringMarket.data;


import org.springframework.stereotype.Component;
import ru.gb.jSilver.SpringMarket.dto.ProductDto;
import ru.gb.jSilver.SpringMarket.dto.ProductListDto;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    private List<ProductListDto> cartList = new ArrayList<>();

    public Cart() {
    }

    public List<ProductListDto> getCartList() {
        return cartList;
    }

    public void setCartList(List<ProductListDto> cartList) {
        this.cartList = cartList;
    }

    public Cart(List<ProductListDto> cartList) {
        this.cartList = cartList;
    }

    public void addProduct(ProductListDto product) {
        cartList.add(product);
    }

    public void removeProduct(ProductListDto product) {
        cartList.remove(product);
    }
}
