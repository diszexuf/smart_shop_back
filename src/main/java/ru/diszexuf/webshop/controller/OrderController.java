package ru.diszexuf.webshop.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.diszexuf.webshop.dto.OrderDTO;
import ru.diszexuf.webshop.model.Order;
import ru.diszexuf.webshop.model.User;
import ru.diszexuf.webshop.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/all_orders")
    public List<Order> findAllOrders() {
        return orderService.findAllOrders();
    }

    @PostMapping("/save_order")
    public Order saveOrder(@RequestBody OrderDTO order) {
        return orderService.saveOrder(order);
    }

    @GetMapping("/{username}")
    public List<Order> findByUser(@PathVariable String username) {
        return orderService.findByUser(username);
    }

    @PutMapping
    public Order updateOrder(@RequestBody Order order) {
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/delete_order")
    public void deleteOrder(Order order) {
        orderService.deleteOrder(order);
    }
}
