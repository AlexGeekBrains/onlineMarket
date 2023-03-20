package com.onlineMarket.core.converters;


import com.onlineMarket.api.dto.CartItemDto;
import com.onlineMarket.core.data.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderItemConverter {

    public CartItemDto entityToDto(OrderItem orderItem) {
        return CartItemDto.builder()
                .productTitle(orderItem.getProduct().getTitle())
                .productId(orderItem.getProduct().getId())
                .quantity(orderItem.getQuantity())
                .pricePerProduct(orderItem.getPricePerProduct())
                .price(orderItem.getPrice())
                .build();
    }
}
