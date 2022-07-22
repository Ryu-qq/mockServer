package com.mockserver.login.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAccountDto {
    private boolean profile_needs_agreement;
    private String name;
    private String email;
}
