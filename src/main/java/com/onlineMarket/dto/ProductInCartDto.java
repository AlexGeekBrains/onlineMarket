package com.onlineMarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInCartDto {
    private Long id;
    private String title;
    private Integer cost;
    private Integer quantity;
}
