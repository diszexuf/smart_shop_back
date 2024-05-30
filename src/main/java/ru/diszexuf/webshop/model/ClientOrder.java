package ru.diszexuf.webshop.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class ClientOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Client client;

    @OneToMany
    private List<OrderItem> orderItems;

//    private int cost = orderItems.stream()
//            .mapToInt(item -> item.getCost() * item.getQuantity())
//            .sum();
}
