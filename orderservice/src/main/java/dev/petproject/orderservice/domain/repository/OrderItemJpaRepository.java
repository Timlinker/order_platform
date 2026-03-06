package dev.petproject.orderservice.domain.repository;

import dev.petproject.orderservice.domain.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemJpaRepository extends JpaRepository<OrderItemEntity, Long> {

}
