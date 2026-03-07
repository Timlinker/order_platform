package dev.petproject.http.payment;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreatePaymentRequestDto {
    private Long orderId;
    private PaymentMethod paymentMethod;
    private BigDecimal amount;

}
