package com.mockserver.login.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenRequestDto {

    private String grant_type;
    private String code;
    private String redirect_uri;
    private String client_id;
    private String client_secret;
}
