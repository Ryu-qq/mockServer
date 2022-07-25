package com.mockserver.login.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ImportWebhookRequestDto {

    private String imp_uid;
    private String merchant_uid;
    private String status;
}
