package com.mockserver.login.service;


import com.mockserver.login.client.ExternClient;
import com.mockserver.login.dto.AddOrderRequestDto;
import com.mockserver.login.dto.ImportPayRequestDto;
import com.mockserver.login.dto.ImportPayloadResponseDto;
import com.mockserver.login.dto.ImportWebhookRequestDto;
import com.mockserver.login.util.ModelMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ExternClient externClient;

    public ResponseEntity addOrder(AddOrderRequestDto addOrderRequestDto) throws Exception {

        ResponseEntity responseEntity
                = externClient.processConfirm(ImportPayRequestDto.builder()
                .imp_uid(addOrderRequestDto.getImportPayloadResponse().getImpUid())
                .merchant_uid(addOrderRequestDto.getImportPayloadResponse().getMerchantUid())
                .amount(String.valueOf(addOrderRequestDto.getImportPayloadResponse().getPaidAmount()))
                .build());


        if(responseEntity.getStatusCode().equals(HttpStatus.OK)){
            webHook(ImportWebhookRequestDto.builder()
                    .imp_uid(addOrderRequestDto.getImportPayloadResponse().getImpUid())
                    .merchant_uid(addOrderRequestDto.getImportPayloadResponse().getMerchantUid())
                    .status("paid")
                    .build());


            return ResponseEntity.ok().body("good");
        }

        return ResponseEntity.badRequest().body("bad");
    }

    public void webHook(ImportWebhookRequestDto importWebhookRequestDto) throws Exception {


        new Thread(new Runnable() {

            private ImportWebhookRequestDto importWebhookRequestDto;

            public Runnable init(ImportWebhookRequestDto importWebhookRequestDto) {
                this.importWebhookRequestDto = importWebhookRequestDto;
                return this;
            }

            @Override
            public void run() {
                externClient.processWebHook(importWebhookRequestDto);
            }
        }.init(importWebhookRequestDto)).start();

    }
}
