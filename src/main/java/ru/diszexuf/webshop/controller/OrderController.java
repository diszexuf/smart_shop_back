package ru.diszexuf.webshop.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.diszexuf.webshop.model.Order;
import ru.diszexuf.webshop.service.IOrderService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
public class OrderController {
    private final IOrderService orderService;

    @GetMapping("/all_orders")
    public List<Order> findAllOrders() {
        return orderService.findAllOrders();
    }

    @PostMapping("save_order")
    public Order saveOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @GetMapping("/{userEmail}_orders")
    public List<Order> findByUserEmail(@PathVariable String userEmail) {
        return orderService.findByUserEmail(userEmail);
    }

    @PutMapping
    public Order updateOrder(Order order) {
        return orderService.updateOrder(order);
    }

    @DeleteMapping()
    public void deleteOrder(Order order) {
        orderService.deleteOrder(order);
    }
}
