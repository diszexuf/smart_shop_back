package ru.diszexuf.webshop.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.diszexuf.webshop.model.Order;
import ru.diszexuf.webshop.repository.IOrderRepository;
import ru.diszexuf.webshop.service.IOrderService;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService implements IOrderService {
    private final IOrderRepository orderRepository;

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findByUserEmail(String userEmail) {
        return orderRepository.findByUserEmail(userEmail);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }
}
