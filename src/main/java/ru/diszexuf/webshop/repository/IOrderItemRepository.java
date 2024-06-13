package ru.diszexuf.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.diszexuf.webshop.model.OrderItem;

public interface IOrderItemRepository extends JpaRepository<OrderItem, Long> {
}
