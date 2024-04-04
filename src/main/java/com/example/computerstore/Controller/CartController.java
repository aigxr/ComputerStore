package com.example.computerstore.Controller;

import com.example.computerstore.Entity.Cart;
import com.example.computerstore.Service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping
    public List<Cart> getAllCarts() {
        return cartService.listOfCarts();
    }

    @GetMapping("/{id}")
    public Cart getCartById(@PathVariable Long id) {
        return cartService.getCartById(id);
    }

    @PostMapping
    public Cart createCart() {
        return cartService.createNewCart();
    }

    @PostMapping("/{cartId}/add/{productId}")
    public Cart addProductIdToCartId(@PathVariable Long cartId, @PathVariable Long productId) {
        return cartService.addProductToCart(productId, cartId);
    }

    @DeleteMapping("/{cartId}/delete/{productId}")
    public void deleteProductIdFromCartId(@PathVariable Long cartId, @PathVariable Long productId) {
        cartService.deleteProductFromCart(cartId, productId);
    }
}