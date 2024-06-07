package ru.diszexuf.webshop.service;


import ru.diszexuf.webshop.model.Order;
import ru.diszexuf.webshop.model.User;

import java.util.List;

public interface OrderService {
    List<Order> findAllOrders();
    Order saveOrder(Order order);
    List<Order> findByUser(User user);
    Order updateOrder(Order order);
    void deleteOrder(Order order);
}
