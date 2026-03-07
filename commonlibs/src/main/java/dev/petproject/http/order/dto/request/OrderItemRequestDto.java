package dev.petproject.http.order.dto.request;

import lombok.Data;

@Data
public class OrderItemRequestDto {
    private Long itemId;
    private Integer quantity;
    private String name;
}
