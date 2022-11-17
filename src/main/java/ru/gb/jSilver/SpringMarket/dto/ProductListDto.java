package ru.gb.jSilver.SpringMarket.dto;

import ru.gb.jSilver.SpringMarket.data.Product;

public class ProductListDto {
    private Long id;
    private String title;
    private Integer price;

    public ProductListDto() {
    }

    public ProductListDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ProductListDto) {
            ProductListDto productListDto = (ProductListDto) obj;
            return productListDto.id == this.id;
        }
        return false;
    }
}
