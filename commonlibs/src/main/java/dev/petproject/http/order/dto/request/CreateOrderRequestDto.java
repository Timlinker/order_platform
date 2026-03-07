package dev.petproject.http.order.dto.request;


import lombok.*;

import java.util.List;

@Data
public class CreateOrderRequestDto {
    private Long customerId;
    private String address;
    private List<OrderItemRequestDto> items;
}
