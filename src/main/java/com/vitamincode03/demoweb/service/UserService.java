package com.vitamincode03.demoweb.service;

import com.vitamincode03.demoweb.dto.request.UserDtoRequest;
import com.vitamincode03.demoweb.dto.response.UserDtoResponse;

import java.util.List;

public interface UserService {

    List<UserDtoResponse> findAll();

    UserDtoResponse findByUsername(String username);

    UserDtoResponse login(UserDtoRequest userDtoRequest);


}
