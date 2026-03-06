package dev.petproject.paymentservice.api.dto;

import dev.petproject.paymentservice.domain.entity.PaymentMethod;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreatePaymentRequestDto {
    private Long orderId;
    private PaymentMethod paymentMethod;
    private BigDecimal amount;

}
