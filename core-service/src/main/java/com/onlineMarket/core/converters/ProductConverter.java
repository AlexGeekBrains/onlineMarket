package com.onlineMarket.core.converters;


import com.onlineMarket.api.dto.CartItemDto;
import com.onlineMarket.api.dto.ProductDto;
import com.onlineMarket.core.soap.products.ProductSoap;
import com.onlineMarket.core.data.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class ProductConverter {

    public Product dtoToEntity(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getTitle(), productDto.getPrice());
    }

    public ProductDto entityToDto(Product product) {
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice());
    }

    public CartItemDto entityToCartItem(Product product, int quantity) {
      return CartItemDto.builder()
              .price(product.getPrice().multiply(BigDecimal.valueOf(quantity)))
              .pricePerProduct(product.getPrice())
              .productId(product.getId())
              .productTitle(product.getTitle())
              .quantity(quantity)
              .build();
    }

    public ProductSoap entityToProductSoap(Product product) {
        ProductSoap productSoap = new ProductSoap();
        productSoap.setId(product.getId());
        productSoap.setCost(product.getPrice());
        productSoap.setTitle(product.getTitle());
        return productSoap;
    }
}