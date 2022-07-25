package com.mockserver.login.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ImportPayRequestDto {

    private String imp_uid;
    private String merchant_uid;
    private String amount;
}
