package dev.petproject.orderservice.api.dto.request;

import lombok.Data;

@Data
public class OrderItemRequestDto {
    private Long itemId;
    private Integer quantity;
    private String name;
}
