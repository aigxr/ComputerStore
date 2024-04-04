package com.example.computerstore.Service;

import com.example.computerstore.Entity.Cart;
import com.example.computerstore.Entity.Order;
import com.example.computerstore.Exceptions.CartNotFoundException;
import com.example.computerstore.Exceptions.OrderNotFoundException;
import com.example.computerstore.Mapper.OrderMapper;
import com.example.computerstore.Repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartService cartService;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order with such id was not found"));
    }
    @Transactional
    public Order createNewOrder(Order order, Long cartId) {
        Cart cart = cartService.getCartById(cartId);
        return orderRepository.save(OrderMapper.map(order, cart.getId()));
    }

//    @Transactional
//    public Order updateOrderById(Long orderId, Order newOrder) {
//        Order foundOrder = getOrderById(orderId);
//        Order updatedOrder = OrderMapper.map(foundOrder, newOrder);
//        return orderRepository.save(updatedOrder);
//    }

    @Transactional
    public void deleteOrderById(Long orderId) {
        Order order = getOrderById(orderId);
        orderRepository.deleteById(order.getId());
    }
}
