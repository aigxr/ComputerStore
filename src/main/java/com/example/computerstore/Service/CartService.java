package com.example.computerstore.Service;

import com.example.computerstore.Entity.Cart;
import com.example.computerstore.Entity.Product;
import com.example.computerstore.Exceptions.CartNotFoundException;
import com.example.computerstore.Exceptions.ProductNotFoundException;
import com.example.computerstore.Repository.CartRepository;
import com.example.computerstore.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    //for admin
    public List<Cart> listOfCarts() {
        return cartRepository.findAll();
    }
    public Cart getCartById(Long cartId) {
        return cartRepository.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException("Cart not found"));
    }

    @Transactional
    public Cart createNewCart() {
        Cart cart = new Cart();
        return cartRepository.save(cart);
    }

    @Transactional
    public Cart addProductToCart(Long productId, Long cartId) {
        Cart cart = getCartById(cartId);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product with such id was not found"));

        cart.getProduct_id().add(product.getId());
        return cartRepository.save(cart);
    }

    @Transactional
    public void deleteProductFromCart(Long cartId, Long productId) {
        Cart cart = getCartById(cartId);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product with such id was not found"));

        cart.getProduct_id().remove(product.getId());
        cartRepository.save(cart);
    }
}
