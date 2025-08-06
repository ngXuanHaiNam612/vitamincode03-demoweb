package com.vitamincode03.demoweb.service;

import com.vitamincode03.demoweb.dto.request.UserDtoRequest;
import com.vitamincode03.demoweb.dto.response.UserDtoResponse;

import java.util.List;

public interface UserService {

    List<UserDtoResponse> findAll();

    List<UserDtoResponse> findByUsername(String username);
    List<UserDtoResponse> findByUsernameList(List<String> usernameList);
    UserDtoResponse login(UserDtoRequest userDtoRequest);

    Integer insertList(List<UserDtoRequest> userDtoRequestList);
    Integer save(UserDtoRequest userDtoRequest);



}
