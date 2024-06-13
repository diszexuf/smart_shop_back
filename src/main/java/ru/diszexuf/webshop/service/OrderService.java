package ru.diszexuf.webshop.service;


import ru.diszexuf.webshop.dto.OrderDTO;
import ru.diszexuf.webshop.model.Order;
import ru.diszexuf.webshop.model.User;

import java.util.List;

public interface OrderService {
    List<Order> findAllOrders();
    Order saveOrder(OrderDTO order);
    List<Order> findByUser(String username);
    Order updateOrder(Order order);
    void deleteOrder(Order order);
}
