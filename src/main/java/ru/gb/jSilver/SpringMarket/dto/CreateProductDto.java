package ru.gb.jSilver.SpringMarket.dto;


public class CreateProductDto {

    private String title;
    private Integer price;

    public CreateProductDto() {
    }

    public CreateProductDto(String title, Integer price) {
        this.title = title;
        this.price = price;
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
