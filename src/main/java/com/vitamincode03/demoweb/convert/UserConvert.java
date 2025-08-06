package com.vitamincode03.demoweb.convert;

import com.vitamincode03.demoweb.dto.request.UserDtoRequest;
import com.vitamincode03.demoweb.dto.response.UserDtoResponse;
import com.vitamincode03.demoweb.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserConvert {

    public static UserDtoResponse convertUserToUserDtoResponse(User user) {
        return UserDtoResponse.builder()
                .username(user.getUsername())
                .role(user.getRole())
                .build();
    }

    public static List<UserDtoResponse> convertListUserToListUserDtoResponse(List<User> userList) {
        return userList
                .stream()
                .map(UserConvert::convertUserToUserDtoResponse)
                .toList();
    }


    public static User convertDtoRequestToEntity(UserDtoRequest dtoRequest) {
        return User.builder()
                .username(dtoRequest.getUsername())
                .password(dtoRequest.getPassword())
                .role(dtoRequest.getRole())
                .build();
    }

    public static List<User> convertListDtoRequestToListEntity(List<UserDtoRequest> dtoRequestList) {
        return dtoRequestList
                .stream()
                .map(UserConvert::convertDtoRequestToEntity)
                .toList();
    }



}
