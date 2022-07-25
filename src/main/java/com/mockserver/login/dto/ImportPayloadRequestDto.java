package com.mockserver.login.dto;


import lombok.Data;

@Data
public class ImportPayloadRequestDto {
    String pg;

    String payMethod;

    String merchantUid;

    String name;

    long amount;

    String buyerEmail;

    String buyerName;

    String buyerTel;

    String buyerAddr;

    String buyerPostcode;


    public ImportPayloadRequestDto generateData(String name, long amount ){
        this.pg = "html5_inicis";
        this.payMethod ="card";
        this.name = name;
        this.amount = amount;
        this.buyerEmail = "test@test.com";
        this.buyerTel ="01011111111";
        this.buyerAddr = "서울시 용산구 새창로 70 109-2204";
        this.buyerPostcode ="12345";
        return this;
    }
}
