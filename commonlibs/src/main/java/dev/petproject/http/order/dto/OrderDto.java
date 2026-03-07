package dev.petproject.http.order.dto;


import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class OrderDto{
        private Long id;
        private Long customerId;
        private String address;
        private BigDecimal totalAmount;
        private String courierName;
        private Integer etaMinutes;
        private OrderStatus orderStatus;
        private Set<OrderItemDto> items;
}

