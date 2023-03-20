package com.onlineMarket.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    private Long id;
    private String username;
    private List<CartItemDto> items;
    private BigDecimal totalPrice;
    private String address;
    private String phone;
}
