package dev.petproject.paymentservice.domain;

import dev.petproject.paymentservice.api.dto.CreatePaymentRequestDto;
import dev.petproject.paymentservice.api.dto.CreatePaymentResponseDto;
import dev.petproject.paymentservice.domain.entity.PaymentMethod;
import dev.petproject.paymentservice.domain.entity.PaymentStatus;
import dev.petproject.paymentservice.domain.repository.PaymentRepository;
import dev.petproject.paymentservice.mapper.PaymentEntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentEntityMapper mapper;


    public CreatePaymentResponseDto makePayment(CreatePaymentRequestDto requestDto) {


        var found = paymentRepository.findByOrderId(requestDto.getOrderId());

        if(found.isPresent()){
            log.info("Этот платёж в бд уже существует по id={}", requestDto.getOrderId());
            return mapper.toResponseDto(found.get());
        }

        var entity = mapper.toEntity(requestDto);

        PaymentStatus paymentStatus = requestDto.getPaymentMethod().equals(PaymentMethod.QR)
                ? PaymentStatus.PAYMENT_FAILED
                : PaymentStatus.PAYMENT_SUCCEEDED;
        entity.setPaymentStatus(paymentStatus);
        var savedEntity = paymentRepository.save(entity);
        return mapper.toResponseDto(savedEntity);
    }
}
