package dev.petproject.paymentservice.api.dto;

import dev.petproject.paymentservice.domain.entity.PaymentMethod;
import dev.petproject.paymentservice.domain.entity.PaymentStatus;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreatePaymentResponseDto {
    private Long paymentId;
    private Long orderId;
    private PaymentMethod paymentMethod;
    private BigDecimal amount;
    private PaymentStatus paymentStatus;
}
