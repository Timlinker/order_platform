package dev.petproject.orderservice.domain.service;

import dev.petproject.orderservice.api.dto.request.CreateOrderRequestDto;
import dev.petproject.orderservice.domain.entity.OrderEntity;
import dev.petproject.orderservice.domain.entity.OrderItemEntity;
import dev.petproject.orderservice.domain.entity.OrderStatus;
import dev.petproject.orderservice.domain.repository.OrderJpaRepository;
import dev.petproject.orderservice.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
@Service
public class OrderProcessor {
    private final OrderJpaRepository orderJpaRepository;
    private final OrderMapper orderMapper;


    public OrderEntity create(CreateOrderRequestDto createOrderRequestDto)
    {
        var entity = orderMapper.toOrderEntity(createOrderRequestDto);
        calculatePricingOrder(entity);
        entity.setOrderStatus(OrderStatus.PENDING_PAYMENT);
        return orderJpaRepository.save(entity);
    }

    public OrderEntity getOrderOrElseThrow(Long id)
    {
        var findOrderEntity = orderJpaRepository.findById(id);

        return findOrderEntity
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Заказ с таким id `%s` не найден".formatted(id)));
    }

    private void calculatePricingOrder(OrderEntity entity) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for(OrderItemEntity item : entity.getItems()){
            var randomPrice = ThreadLocalRandom.current().nextDouble(100, 5000);
            item.setPriceAtPurchase(BigDecimal.valueOf(randomPrice));
            totalPrice = item.getPriceAtPurchase().multiply(BigDecimal.valueOf(item.getQuantity())
                    .add(totalPrice));
            entity.setTotalAmount(totalPrice);
        }
    }
}
