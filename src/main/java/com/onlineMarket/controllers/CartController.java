package com.onlineMarket.controllers;

import com.onlineMarket.bean.Cart;
import com.onlineMarket.dto.ProductDto;
import com.onlineMarket.dto.ProductInCartDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/carts")
public class CartController {
    private final Cart cart;

    @GetMapping()
    public List<ProductInCartDto> showCart() {
        return cart.getProducts();
    }

    @GetMapping("/add")
    public List<ProductInCartDto> addProductToCart(@RequestParam Long productId) {
        return cart.addProductCartById(productId);
    }

    @GetMapping("/remove/{productId}")
    public List<ProductInCartDto> removeProductFromCart(@PathVariable Long productId) {
        return cart.removeProductFromCartById(productId);
    }
}
