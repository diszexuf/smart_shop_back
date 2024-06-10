package ru.diszexuf.webshop.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "user_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    private String orderDate;

    //todo чекнуть запросы
    private String orderStatus;

    @OneToMany
    private List<OrderItem> orderItems;

}
