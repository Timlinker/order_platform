package dev.petproject.orderservice.domain.repository;

import dev.petproject.orderservice.domain.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {

}
