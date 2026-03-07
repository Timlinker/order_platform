package dev.petproject.http.payment;


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
