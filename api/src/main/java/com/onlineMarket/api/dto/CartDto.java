package com.onlineMarket.api.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Data
public class CartDto {
    private List<CartItemDto> products;
    private BigDecimal totalPrice;
}