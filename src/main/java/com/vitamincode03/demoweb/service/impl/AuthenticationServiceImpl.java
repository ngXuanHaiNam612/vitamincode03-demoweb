package com.vitamincode03.demoweb.service.impl;

import com.vitamincode03.demoweb.dto.request.AuthenticationDtoRequest;
import com.vitamincode03.demoweb.dto.response.AuthenticationDtoResponse;
import com.vitamincode03.demoweb.enums.ErrorCode;
import com.vitamincode03.demoweb.exception.AppException;
import com.vitamincode03.demoweb.mapper.UserMapper;
import com.vitamincode03.demoweb.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthenticationDtoResponse authenticate(AuthenticationDtoRequest request) {
        // get user từ database theo username
        var users = userMapper.findByUsername(request.getUsername());

        // kiem tra du lieu tra ve co user trung khop username khong
        if(users == null || users.isEmpty()) throw new AppException(ErrorCode.USER_NOT_FOUND);

        // xac nhan mat khau
        log.info(">>>>> Pass from request: " + request.getUsername());
        log.info(">>>>> Pass from database: " + users.get(0).getPassword());

        boolean authenticated = passwordEncoder.matches(request.getPassword(), users.get(0).getPassword());

        if(!authenticated) throw new AppException(ErrorCode.INCORRECT_PASSWORD);

        return AuthenticationDtoResponse.
                builder()
                .authenticated(authenticated)
                .build();
    }
}
