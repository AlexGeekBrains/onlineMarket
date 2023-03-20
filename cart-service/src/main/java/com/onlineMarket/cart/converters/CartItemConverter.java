package com.onlineMarket.cart.converters;

import com.onlineMarket.api.dto.CartItemDto;
import com.onlineMarket.cart.model.CartItem;
import org.springframework.stereotype.Component;

@Component
public class CartItemConverter {
    public CartItemDto entityToDto(CartItem cartItem) {
        return CartItemDto.builder()
                .price(cartItem.getPrice())
                .pricePerProduct(cartItem.getPricePerProduct())
                .quantity(cartItem.getQuantity())
                .productId(cartItem.getProductId())
                .productTitle(cartItem.getProductTitle())
                .build();
    }
}