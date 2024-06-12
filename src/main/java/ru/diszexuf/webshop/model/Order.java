package ru.diszexuf.webshop.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "user_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String orderDate;
    private String orderStatus;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
}
