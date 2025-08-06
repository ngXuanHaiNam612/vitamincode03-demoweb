package com.vitamincode03.demoweb.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoRequest {
    private String username;
    private String password;
    private String role;
}
