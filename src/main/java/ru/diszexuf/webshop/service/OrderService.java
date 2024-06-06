package ru.diszexuf.webshop.service;


import ru.diszexuf.webshop.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAllOrders();
    Order saveOrder(Order order);
    List<Order> findByUserEmail(String userEmail);
    Order updateOrder(Order order);
    void deleteOrder(Order order);
}
