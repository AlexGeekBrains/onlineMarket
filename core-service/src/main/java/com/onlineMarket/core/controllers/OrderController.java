package com.onlineMarket.core.controllers;


import com.onlineMarket.api.dto.OrderDetailsDto;
import com.onlineMarket.api.dto.OrderDto;
import com.onlineMarket.core.converters.OrderConverter;
import com.onlineMarket.core.data.User;
import com.onlineMarket.core.services.OrderService;
import com.onlineMarket.core.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/orders")
public class OrderController {
    private final UserService userService;
    private final OrderService orderService;
    private final OrderConverter orderConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(Principal principal, @RequestBody OrderDetailsDto orderDetailsDto){
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        orderService.createOrder(user, orderDetailsDto);
    }

    @GetMapping
    public List<OrderDto> getCurrentUserOrders(Principal principal) {
        return orderService.findOrdersByUsername(principal.getName()).stream()
                .map(orderConverter::entityToDto).collect(Collectors.toList());
    }
}
