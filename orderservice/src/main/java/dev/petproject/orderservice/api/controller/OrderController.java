package dev.petproject.orderservice.api.controller;

import dev.petproject.orderservice.api.dto.OrderDto;
import dev.petproject.orderservice.api.dto.request.CreateOrderRequestDto;
import dev.petproject.orderservice.domain.service.OrderProcessor;
import dev.petproject.orderservice.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderProcessor orderProcessor;
    private final OrderMapper orderMapper;

    @PostMapping
    public OrderDto create(@RequestBody CreateOrderRequestDto createOrderRequestDto)
    {
        var saved = orderProcessor.create(createOrderRequestDto);
        log.info("Заказ создан с id {}", createOrderRequestDto);
        return orderMapper.toOrderDto(saved);
    }

    @GetMapping("/{id}")
    public OrderDto getOne(@PathVariable Long id)
    {
        var found = orderProcessor.getOrderOrElseThrow(id);
        log.info("Заказ найден по id {}", id);
        return orderMapper.toOrderDto(found);
    }


}
