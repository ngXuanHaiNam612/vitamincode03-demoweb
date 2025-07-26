package com.vitamincode03.demoweb.convert;

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



}
