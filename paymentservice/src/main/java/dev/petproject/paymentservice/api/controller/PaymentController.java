package dev.petproject.paymentservice.api.controller;

import dev.petproject.paymentservice.api.dto.CreatePaymentRequestDto;
import dev.petproject.paymentservice.api.dto.CreatePaymentResponseDto;
import dev.petproject.paymentservice.domain.PaymentService;
import dev.petproject.paymentservice.domain.entity.PaymentMethod;
import dev.petproject.paymentservice.domain.entity.PaymentStatus;
import dev.petproject.paymentservice.domain.repository.PaymentRepository;
import dev.petproject.paymentservice.mapper.PaymentEntityMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
@Slf4j
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public CreatePaymentResponseDto createPayment(@RequestBody CreatePaymentRequestDto requestDto){
        log.info("Получен запрос: paymentRequest={}", requestDto);
        return paymentService.makePayment(requestDto);
    }


}
