package com.mockserver.login.dto;


import lombok.Data;

@Data
public class MemberDeliveryAddressDto {
    long deliveryAddressId;

    String deliveryAddressName;

    String memberId;

    String receiverName;

    String receiverMobilePhoneNo;

    String receiverZipCode;

    String receiverRoadAddress;

    String receiverAddressDetail;

    String receiverDeliveryRequest;

    String defaultDeliveryAddressYn;

    public MemberDeliveryAddressDto generateData(String memberId, String receiverName){
        this.deliveryAddressId = 1L;
        this.deliveryAddressName = "test주소";
        this.memberId =memberId;
        this.receiverName = receiverName;
        this.receiverMobilePhoneNo = "01011111111";
        this.receiverZipCode ="12345";
        this.receiverRoadAddress="새창로 70";
        this.receiverAddressDetail = "109-2204";
        this.receiverDeliveryRequest="";
        this.defaultDeliveryAddressYn ="Y";
        return this;
    }
}
