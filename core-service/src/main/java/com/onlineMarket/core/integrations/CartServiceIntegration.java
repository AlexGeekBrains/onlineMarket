package com.onlineMarket.core.integrations;

import com.onlineMarket.api.dto.CartDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


@Component
@RequiredArgsConstructor
public class CartServiceIntegration {

    private final WebClient cartServiceWebClient;

    public CartDto getCart() {
        return cartServiceWebClient.get()
                .uri("/api/v1/cart")
                .retrieve()
                .bodyToMono(CartDto.class)
                .block();
    }

    public void clearCart() {
        cartServiceWebClient.get()
                .uri("/api/v1/cart/clear")
//                .header("username", username)
                .retrieve()
                .toBodilessEntity()
                .block();
    }
}