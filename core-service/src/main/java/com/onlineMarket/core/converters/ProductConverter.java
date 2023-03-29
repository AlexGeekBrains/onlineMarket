package com.onlineMarket.core.converters;


import com.onlineMarket.api.dto.CartItemDto;
import com.onlineMarket.api.dto.ProductDto;
import com.onlineMarket.core.soap.products.ProductSoap;
import com.onlineMarket.core.data.Product;
import org.springframework.stereotype.Component;


@Component
public class ProductConverter {

    public ProductDto entityToDto(Product product) {
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice());
    }

    public Product dtoToEntity(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getTitle(), productDto.getPrice());
    }

    public ProductSoap entityToProductSoap(Product product) {
        ProductSoap productSoap = new ProductSoap();
        productSoap.setId(product.getId());
        productSoap.setCost(product.getPrice());
        productSoap.setTitle(product.getTitle());
        return productSoap;
    }

    public CartItemDto entityToCartItem(Product product, int quantity) {
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setProductTitle(product.getTitle());
        cartItemDto.setProductId(product.getId());
        cartItemDto.setQuantity(quantity);
        cartItemDto.setPricePerProduct(product.getPrice());
        return cartItemDto;
    }
}