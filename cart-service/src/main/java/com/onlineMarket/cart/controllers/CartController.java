package com.onlineMarket.cart.controllers;


import com.onlineMarket.api.dto.CartDto;
import com.onlineMarket.cart.converters.CartConverter;
import com.onlineMarket.cart.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/cart")
@CrossOrigin("*")
public class CartController {
    private final CartService cartService;
    private final CartConverter cartConverter;


    @GetMapping()
    public CartDto getCurrentCart() {
        return cartConverter.entityToDto(cartService.getCurrentCart());
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
