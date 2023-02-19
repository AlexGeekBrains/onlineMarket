package com.onlineMarket.cart.services;


import com.onlineMarket.api.dto.ProductDto;
import com.onlineMarket.cart.integrations.ProductServiceIntegration;
import com.onlineMarket.cart.model.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/*ДЗ
* Если польщователь не залогинен, то ему должна быть выдана общая корзина
* Если пользователь залогинен, то ему должна быть выдана его корзина
* Добавит пагинацию на фронт (Кнопки  <- пред. стр. 1,2,3,4 ... след. стр.-> */
@Service
@RequiredArgsConstructor
public class CartService {
    private Map<String, Cart> carts;

    private final ProductServiceIntegration productServiceIntegration;

    @PostConstruct
    public void init() {
        carts = new HashMap<>();

    }

    public Cart getCurrentCart(String username) {
        if (!carts.containsKey(username)) {
            carts.put(username, new Cart());
        }
        return carts.get(username);
    }

    public void add(String username, Long productId) {
        ProductDto product = productServiceIntegration.findById(productId);
        getCurrentCart(username).addProduct(product);

    }

    public void delete(String username, Long productId) {
        ProductDto product = productServiceIntegration.findById(productId);
        getCurrentCart(username).removeProduct(product);
    }

    public void clear(String username) {
        getCurrentCart(username).clearCart();
    }

    public void changeQuantityProduct(String username, Long productId, Integer delta) {
        getCurrentCart(username).changeQuantity(productId, delta);
    }
}
