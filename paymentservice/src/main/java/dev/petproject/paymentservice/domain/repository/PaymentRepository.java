package dev.petproject.paymentservice.domain.repository;

import dev.petproject.paymentservice.domain.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long>
{
    Optional<PaymentEntity> findByOrderId(Long orderId);
}
