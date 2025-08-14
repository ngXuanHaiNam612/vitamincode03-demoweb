package com.vitamincode03.demoweb.dto.request;

import lombok.Data;

@Data
public class AuthenticationDtoRequest {
    private String username;
    private String password;
}
