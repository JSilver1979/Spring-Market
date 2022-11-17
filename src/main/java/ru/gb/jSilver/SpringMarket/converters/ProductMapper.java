package ru.gb.jSilver.SpringMarket.converters;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.factory.Mappers;
import ru.gb.jSilver.SpringMarket.data.Product;
import ru.gb.jSilver.SpringMarket.dto.CreateProductDto;
import ru.gb.jSilver.SpringMarket.dto.ProductDto;
import ru.gb.jSilver.SpringMarket.dto.ProductListDto;

public interface ProductMapper {
    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    Product toProductFromDto(ProductDto productDto);

    Product toProductFromCreateDto(CreateProductDto productDto);

    Product toProductFromProductListDto(ProductListDto productListDto);

    @InheritInverseConfiguration
    ProductDto fromProduct(Product product);

    @InheritInverseConfiguration
    ProductListDto fromProductToListDto(Product product);
}
