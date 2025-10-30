package com.bcf.jwt1.dto;


import lombok.Data;

@Data
public class AuthenticationRequest {
    private String username;
    private String password;
}
