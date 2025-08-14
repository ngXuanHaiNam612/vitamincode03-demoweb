package com.vitamincode03.demoweb.controller;


import com.vitamincode03.demoweb.dto.request.AuthenticationDtoRequest;
import com.vitamincode03.demoweb.dto.response.ApiResponse;
import com.vitamincode03.demoweb.dto.response.AuthenticationDtoResponse;
import com.vitamincode03.demoweb.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    ApiResponse<AuthenticationDtoResponse> doLogin(@RequestBody AuthenticationDtoRequest request) {
        return ApiResponse.<AuthenticationDtoResponse>builder()
                .statusCode(200)
                .success(Boolean.TRUE)
                .message("Gọi api thành công")
                .data(authenticationService.authenticate(request))
                .build();
    }

}
