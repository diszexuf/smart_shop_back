package ru.diszexuf.webshop.dto;

import lombok.Data;
import ru.diszexuf.webshop.model.OrderItem;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class OrderDTO {
    private Long userId;
    private String orderDate;
    private String orderStatus;
    private List<OrderItemDTO> orderItems;

}
