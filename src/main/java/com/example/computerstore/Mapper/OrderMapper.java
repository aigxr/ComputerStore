package com.example.computerstore.Mapper;

import com.example.computerstore.Entity.Order;

import java.time.LocalDateTime;

public class OrderMapper {
    public static Order map(Order order, Long cartId) {
        Order newOrder = new Order();
        newOrder.setId(order.getId());
        newOrder.setCartId(cartId);
        newOrder.setCity(order.getCity());
        newOrder.setAddress(order.getAddress());
        newOrder.setDate(LocalDateTime.now());
        return newOrder;
    }

    public static Order map(Order oldOrder, Order newOrder) {
        oldOrder.setId(newOrder.getId());
        oldOrder.setCity(newOrder.getCity());
        oldOrder.setAddress(newOrder.getAddress());
        return oldOrder;
    }
}
