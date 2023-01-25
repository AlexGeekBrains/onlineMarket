package com.onlineMarket.controllers;

import com.onlineMarket.dto.Cart;
import com.onlineMarket.dto.ProductInCartDto;
import com.onlineMarket.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/cart")
public class CartController {
    private final CartService cartService;

    @GetMapping()
    public Cart getCurrentCart() {
        return cartService.getCurrentCart();
    }

    @GetMapping("/add")
    public void addProductToCart(@RequestParam Long productId) {
        cartService.add(productId);
    }

    @GetMapping("/remove/{productId}")
    public void removeProductFromCart(@PathVariable Long productId) {
        cartService.delete(productId);
    }
    @GetMapping("/clear")
    public void clearCart() {
        cartService.clear();
    }

    @GetMapping("/change_quantity")
    public void changeQuantityProductInCart(@RequestParam Long productId, Integer delta) {
        cartService.changeQuantityProduct(productId,delta);
    }
}
