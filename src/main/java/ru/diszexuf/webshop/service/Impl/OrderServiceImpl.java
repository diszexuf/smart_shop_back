package ru.diszexuf.webshop.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.diszexuf.webshop.dto.OrderDTO;
import ru.diszexuf.webshop.dto.OrderItemDTO;
import ru.diszexuf.webshop.model.Order;
import ru.diszexuf.webshop.model.OrderItem;
import ru.diszexuf.webshop.model.Product;
import ru.diszexuf.webshop.model.User;
import ru.diszexuf.webshop.repository.IOrderRepository;
import ru.diszexuf.webshop.repository.IProductRepository;
import ru.diszexuf.webshop.repository.IUserRepository;
import ru.diszexuf.webshop.service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final IOrderRepository orderRepository;
    private final IUserRepository userRepository;
    private final IProductRepository productRepository;

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }
    @Override
    public Order saveOrder(OrderDTO order) {
        Order orderAdd = new Order();
        orderAdd.setOrderDate(order.getOrderDate());
        orderAdd.setOrderStatus(order.getOrderStatus());
        User user = userRepository.findById(order.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        orderAdd.setUser(user);

        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItemDTO item : order.getOrderItems()) {
            Product product = productRepository.findById(item.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(product.getId());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setOrder(orderAdd);
            orderItems.add(orderItem);
        }

        orderAdd.setOrderItems(orderItems);

        return orderRepository.save(orderAdd);
    }

    @Override
    public List<Order> findByUser(String user) {
        User user1 = userRepository.findByUsername(user).orElseThrow(() -> new RuntimeException("User not found"));
        return orderRepository.findByUser(user1);
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
