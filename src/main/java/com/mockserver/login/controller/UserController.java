package com.mockserver.login.controller;


import com.mockserver.login.dto.UserAccountDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;

@RestController()
@RequestMapping("/v1/user")
public class UserController {


    @GetMapping("/me")
    public ResponseEntity<HashMap<String, Object>> generateMember(){
        System.out.println("me = " + 3);

        HashMap<String, Object> map = new HashMap<>();
        UserAccountDto mock_account = UserAccountDto.builder()
                .name("회원님" + UUID.randomUUID().toString().substring(0, 8))
                .email("email" + UUID.randomUUID().toString().substring(0, 8) + "@mock.com")
                .profile_needs_agreement(true)
                .build();


        map.put("id", UUID.randomUUID().toString().substring(0, 8));
        map.put("mock_account", mock_account);

        return ResponseEntity.ok().body(map);

    }
}
