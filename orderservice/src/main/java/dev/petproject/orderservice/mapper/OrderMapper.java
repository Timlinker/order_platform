package dev.petproject.orderservice.mapper;

import dev.petproject.orderservice.api.dto.OrderDto;
import dev.petproject.orderservice.api.dto.request.CreateOrderRequestDto;
import dev.petproject.orderservice.domain.entity.OrderEntity;
import org.mapstruct.*;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

    OrderEntity toOrderEntity(CreateOrderRequestDto orderDto);

    OrderDto toOrderDto(OrderEntity orderEntity);

    @AfterMapping
    default void linkOrderItemEntities(@MappingTarget OrderEntity orderEntity)
    {
        orderEntity.getItems()
                .forEach(orderItemEntity -> orderItemEntity.setOrder(orderEntity));
    }
}
