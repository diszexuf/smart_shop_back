package ru.diszexuf.webshop.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = true)
    private Category category;


    // todo посмотреть как хранить пикчи
    private String image;

    private Integer price;
}
