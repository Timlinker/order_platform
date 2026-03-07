package dev.petproject.http.order.dto;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDto{
        private Long id;
        private Integer quantity;
        private BigDecimal priceAtPurchase;
        private Long itemId;
}
