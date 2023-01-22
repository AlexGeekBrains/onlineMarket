package com.onlineMarket.converters;

import com.onlineMarket.data.Product;
import com.onlineMarket.dto.ProductDto;
import com.onlineMarket.dto.ProductInCartDto;
import org.springframework.stereotype.Component;


@Component
public class ProductConverter {

    public Product dtoToEntity(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getTitle(), productDto.getCost());
    }

    public ProductDto entityToDto(Product product) {
        return new ProductDto(product.getId(), product.getTitle(), product.getCost());
    }

    public ProductInCartDto productDtoToProductInCartDto(ProductDto productDto, int quantity) {
        return new ProductInCartDto(productDto.getId(), productDto.getTitle(), productDto.getCost(), quantity);
    }

    public ProductDto ProductInCartDtoToProductDto( ProductInCartDto productInCartDto) {
        return new ProductDto(productInCartDto.getId(), productInCartDto.getTitle(), productInCartDto.getCost());
    }
}