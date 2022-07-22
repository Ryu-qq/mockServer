package com.mockserver.login.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizationTokenRequestDto {
    private String response_type;
    private String client_id;
    private String scope;
    private String state;
    private String redirect_uri;
}
