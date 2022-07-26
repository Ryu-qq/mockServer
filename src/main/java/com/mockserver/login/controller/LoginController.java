package com.mockserver.login.controller;


import com.mockserver.login.dto.TokenResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class LoginController {
    @GetMapping("login/redirect")
    public ResponseEntity getAccessToken(@RequestParam("token") String accessToken){
        System.out.println("accessToken = " + accessToken);
        return ResponseEntity.ok().body(TokenResponseDto.builder().token(accessToken).build());
    }

    @GetMapping("/")
    public String helloWorld(){return"hello mock world";}

}
