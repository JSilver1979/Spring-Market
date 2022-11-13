package ru.gb.jSilver.SpringMarket.dto;

import lombok.NoArgsConstructor;

public class DeleteProductDto {
    private Long id;

    public DeleteProductDto() {
    }

    public DeleteProductDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
