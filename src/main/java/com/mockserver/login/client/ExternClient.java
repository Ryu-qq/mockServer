package com.mockserver.login.client;


import com.mockserver.login.dto.AddOrderRequestDto;
import com.mockserver.login.dto.ImportPayRequestDto;
import com.mockserver.login.dto.ImportWebhookRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "externApiClient", url="${ExApi.localUrl}/import")
public interface ExternClient {

    @PostMapping(value = "/confirm")
    ResponseEntity processConfirm(@RequestBody ImportPayRequestDto importPayRequestDto);

    @PostMapping(value = "/webHook")
    ResponseEntity processWebHook(@RequestBody ImportWebhookRequestDto importWebhookRequestDto);
}
