package dev.petproject.paymentservice.mapper;

import dev.petproject.paymentservice.api.dto.CreatePaymentRequestDto;
import dev.petproject.paymentservice.api.dto.CreatePaymentResponseDto;
import dev.petproject.paymentservice.domain.entity.PaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentEntityMapper {

    PaymentEntity toEntity(CreatePaymentRequestDto requestDto);

    @Mapping(source = "id", target = "paymentId")
    CreatePaymentResponseDto toResponseDto(PaymentEntity savedEntity);
}
