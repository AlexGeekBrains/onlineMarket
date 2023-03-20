package com.onlineMarket.api.dto;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CartItemDto {
    private Long productId;
    private String productTitle;
    private BigDecimal pricePerProduct;
    private Integer quantity;
    private BigDecimal price;
}