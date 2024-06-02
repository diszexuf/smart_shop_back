package ru.diszexuf.webshop.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ProductSpecifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "specifications_id", nullable = false)
    private Specifications specifications;

    private String value;
}
