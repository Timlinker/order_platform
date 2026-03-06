package dev.petproject.orderservice.api.dto;

import dev.petproject.orderservice.domain.entity.OrderItemEntity;
import dev.petproject.orderservice.domain.entity.OrderStatus;
import lombok.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.List;
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

