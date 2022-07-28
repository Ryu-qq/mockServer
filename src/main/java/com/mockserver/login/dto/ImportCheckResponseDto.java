package com.mockserver.login.dto;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ImportCheckResponseDto {

    private String memberId;

    private long paymentId;

    private String impUid;

    private String merchantUid;

    private long paymentAmount;

    private String payMethod;

    private String channel;

    private String pgProvider;

    private String embPgProvider;

    private String pgTid;

    private boolean escrow;

    private String applyNum;

    private String bankCode;
    private String bankName;
    private String cardCode;
    private String cardName;

    private String cardNumber;
    private String cardQuota;
    private String cardType;
    private String vBankCode;
    private String vBankName;

    private String vBankNum;
    private String vBankHolder;
    private Date vBankDate;
    private String vBankIssuedAt;
    private String name;
    private long amount;
    private long cancelAmount;

    private String currency;
    private String buyerEmail;
    private String buyerName;
    private String buyerTel;
    private String buyerAddr;

    private String buyerPostCode;
    private String status;
    private String failReason;


    private String customData;

    private long startedAt;
    private Date paidAt;
    private Date failedAt;
    private Date cancelled_At;

    private String cancelReason;
    private String receiptUrl;
    private String cashReceiptIssued;
    private String customerUid;
    private String customerUidUsage;
}
