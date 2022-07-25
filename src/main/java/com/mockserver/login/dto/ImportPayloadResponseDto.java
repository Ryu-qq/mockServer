package com.mockserver.login.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class ImportPayloadResponseDto {
    String impUid;
    String merchantUid;
    long paidAmount;


    public ImportPayloadResponseDto generateData(long paymentId, long paidAmount){
        this.impUid = "imp_" + UUID.randomUUID().toString().substring(0,13);
        this.merchantUid ="ORDER" +String.valueOf(LocalDate.now()).replaceAll("[^\uAC00-\uD7A30-9a-zA-Z]", "") + "-" + paymentId;
        this.paidAmount =paidAmount;
        return this;
    }
}
