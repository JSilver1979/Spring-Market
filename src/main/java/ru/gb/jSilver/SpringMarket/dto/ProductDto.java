package ru.gb.jSilver.SpringMarket.dto;

import ru.gb.jSilver.SpringMarket.data.Product;

public class ProductDto {

    private String title;
    private Integer price;

    public ProductDto(Product product) {
        this.title = product.getTitle();
        this.price = product.getPrice();
    }

    public ProductDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
