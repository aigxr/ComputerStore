package com.example.computerstore.Controller;

import com.example.computerstore.Entity.Order;
import com.example.computerstore.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/add/{cartId}")
    public Order createNewOrderWithCartId(@PathVariable Long cartId, @RequestBody Order order) {
        return orderService.createNewOrder(order, cartId);
    }

//    @PutMapping("/update/{orderId}")
//    public Order updateOrderById(@PathVariable Long orderId, @RequestBody Order newOrder) {
//        return orderService.updateOrderById(orderId, newOrder);
//    }

    @DeleteMapping("/delete/{orderId}")
    public void deleteOrderById(@PathVariable Long orderId) {
        orderService.deleteOrderById(orderId);
    }
}
