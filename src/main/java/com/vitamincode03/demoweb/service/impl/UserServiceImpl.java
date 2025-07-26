package com.vitamincode03.demoweb.service.impl;


import com.vitamincode03.demoweb.convert.UserConvert;
import com.vitamincode03.demoweb.dto.request.UserDtoRequest;
import com.vitamincode03.demoweb.dto.response.UserDtoResponse;
import com.vitamincode03.demoweb.entity.User;
import com.vitamincode03.demoweb.mapper.UserMapper;
import com.vitamincode03.demoweb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserMapper userMapper;

    @Override
    public List<UserDtoResponse> findAll() {

//        List<User> users = userMapper.findAll();
//        => conver users thành List<UserDtoResponse>
        var users = UserConvert.convertListUserToListUserDtoResponse(userMapper.findAll());
        if(Objects.isNull(users)){
            return null;
        }
        return users;
    }

    @Override
    public UserDtoResponse findByUsername(String username) {
        var users = UserConvert.convertUserToUserDtoResponse(userMapper.findByUsername(username));
        if(Objects.isNull(users)){
            return null;
        }
        return users;
    }

    @Override
    public UserDtoResponse login(UserDtoRequest userDtoRequest) {
        if(Objects.nonNull(userDtoRequest)){
            var user= userMapper.findByUsername(userDtoRequest.getUsername());
            if(Objects.nonNull(user) && user.getPassword().equals(userDtoRequest.getPassword())){
                return UserConvert.convertUserToUserDtoResponse(user);
            }
        }
        return null;
    }

}
