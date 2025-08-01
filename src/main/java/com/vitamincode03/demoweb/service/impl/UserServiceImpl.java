package com.vitamincode03.demoweb.service.impl;


import com.vitamincode03.demoweb.convert.UserConvert;
import com.vitamincode03.demoweb.dto.request.UserDtoRequest;
import com.vitamincode03.demoweb.dto.response.UserDtoResponse;
import com.vitamincode03.demoweb.enums.ErrorCode;
import com.vitamincode03.demoweb.exception.AppException;
import com.vitamincode03.demoweb.mapper.UserMapper;
import com.vitamincode03.demoweb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserMapper userMapper;

    @Override
    public List<UserDtoResponse> findAll() {
        var users = UserConvert.convertListUserToListUserDtoResponse(userMapper.findAll());
        if(users.isEmpty()) {
            throw new AppException(ErrorCode.LIST_USER_NOT_FOUND);
        }
        return users;
    }

    @Override
    public List<UserDtoResponse> findByUsername(String username) {
        var users = UserConvert.convertListUserToListUserDtoResponse(userMapper.findByUsername(username));
        if(users.isEmpty()){
            return null;
        }
        return users;
    }

    @Override
    public UserDtoResponse login(UserDtoRequest userDtoRequest) {
        if(Objects.nonNull(userDtoRequest)){
            var user= userMapper.findByUsername(userDtoRequest.getUsername());
            if(Objects.nonNull(user) && user.get(0).getPassword().equals(userDtoRequest.getPassword())){
                return UserConvert.convertUserToUserDtoResponse(user.get(0));
            }
        }
        return null;
    }

}
