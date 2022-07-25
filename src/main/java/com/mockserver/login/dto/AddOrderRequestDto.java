package com.mockserver.login.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class AddOrderRequestDto {

    List<Long> cartIds;
    MemberDeliveryAddressDto MemberDeliveryAddress;
    PaymentMethodDto paymentMethod;
    ImportPayloadRequestDto importPayloadRequest;
    ImportPayloadResponseDto importPayloadResponse;







}
