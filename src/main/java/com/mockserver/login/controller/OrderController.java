package com.mockserver.login.controller;


import com.mockserver.login.dto.AddOrderRequestDto;
import com.mockserver.login.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public void addOrder(@RequestBody AddOrderRequestDto addOrderRequestDto) throws Exception {
        ResponseEntity.ok().body(orderService.addOrder(addOrderRequestDto));
    }
}
