package ru.gb.jSilver.SpringMarket.data;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Cart {
    private List<Product> cartList;

    public Cart() {
    }

    public List<Product> getCartList() {
        return cartList;
    }

    public void setCartList(List<Product> cartList) {
        this.cartList = cartList;
    }

    public Cart(List<Product> cartList) {
        this.cartList = cartList;
    }

    public void addProduct(Product product) {
        cartList.add(product);
    }

    public void removeProduct(Product product) {
        cartList.remove(product);
    }
}
