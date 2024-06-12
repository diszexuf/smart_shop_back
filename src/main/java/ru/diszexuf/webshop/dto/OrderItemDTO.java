package ru.diszexuf.webshop.dto;

import lombok.Data;

@Data
public class OrderItemDTO {
    private Long productId;
    private Integer  quantity;

}

