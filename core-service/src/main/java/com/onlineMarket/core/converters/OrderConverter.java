package com.onlineMarket.core.converters;

import com.onlineMarket.api.dto.OrderDto;
import com.onlineMarket.core.data.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderConverter {
    private final OrderItemConverter orderItemConverter;

    public Order dtoToEntity(OrderDto orderDto) {
        throw new UnsupportedOperationException();
    }

    public OrderDto entityToDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .address(order.getAddress())
                .phone(order.getPhone())
                .totalPrice(order.getTotalPrice())
                .username(order.getUsername())
                .items(order.getItems().stream().map(orderItemConverter::entityToDto).collect(Collectors.toList()))
                .build();
    }
}
