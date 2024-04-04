package com.example.computerstore.Service;

import com.example.computerstore.Entity.Product;
import com.example.computerstore.Exceptions.ProductNotFoundException;
import com.example.computerstore.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product getProduct(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product with id: " + productId + "was not found"));
    }
}
