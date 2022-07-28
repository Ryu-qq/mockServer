package com.mockserver.login.controller;


import com.mockserver.login.dto.AddOrderRequestDto;
import com.mockserver.login.dto.ImportCheckResponseDto;
import com.mockserver.login.dto.ImportWebhookRequestDto;
import com.mockserver.login.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public void addOrder(@RequestBody AddOrderRequestDto addOrderRequestDto) throws Exception {
        ResponseEntity.ok().body(orderService.addOrder(addOrderRequestDto));
    }

    @GetMapping("/check")
    public void checkOrder(@RequestBody ImportWebhookRequestDto importWebhookRequestDto) throws Exception {
        ResponseEntity.ok().body(ImportCheckResponseDto.builder()
                        .impUid(importWebhookRequestDto.getImp_uid())
                        .merchantUid(importWebhookRequestDto.getMerchant_uid())
                        .payMethod("card")
                        .channel("mobile")
                        .pgProvider("kcp")
                        .pgTid(String.valueOf(Math.random()))
                        .escrow(false)
                        .applyNum(String.valueOf(Math.random()))
                        .cardCode("666")
                        .cardName("외환카드")
                        .cardNumber(String.valueOf(Math.random()))
                        .cardQuota("3")
                        .currency("KWR")
                        .status("paid")
                .build());
    }
}
