package com.vitamincode03.demoweb.service.impl;

import com.vitamincode03.demoweb.convert.UserConvert;
import com.vitamincode03.demoweb.dto.request.UserDtoRequest;
import com.vitamincode03.demoweb.dto.response.UserDtoResponse;
import com.vitamincode03.demoweb.entity.User;
import com.vitamincode03.demoweb.enums.ErrorCode;
import com.vitamincode03.demoweb.exception.AppException;
import com.vitamincode03.demoweb.mapper.UserMapper;
import com.vitamincode03.demoweb.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserMapper userMapper;

    @Override
    public List<UserDtoResponse> findAll() {
        var users = UserConvert.convertListUserToListUserDtoResponse(userMapper.findAll());
        if (users.isEmpty()) {
            throw new AppException(ErrorCode.LIST_USER_NOT_FOUND);
        }
        return users;
    }

    @Override
    public UserDtoResponse findByUsername(String username) {
        var users = UserConvert.convertListUserToListUserDtoResponse(userMapper.findByUsername(username));
        if (!users.isEmpty()) {
            return users.get(0);
        } else {
            throw new AppException(ErrorCode.USER_NOT_FOUND);
        }
    }

    @Override
    public List<UserDtoResponse> findByUsernameList(List<String> usernameList) {
        var users = UserConvert.convertListUserToListUserDtoResponse(userMapper.findByUsernameList(usernameList));
        if (!users.isEmpty()) {
            return users;
        } else {
            throw new AppException(ErrorCode.LIST_USER_NOT_FOUND);
        }
    }

    @Transactional
    @Override
    public Integer insertList(List<UserDtoRequest> userDtoRequestList) {
        if (!userDtoRequestList.isEmpty()) {
            var entityList = UserConvert.convertListDtoRequestToListEntity(userDtoRequestList);
            return userMapper.insertList(entityList);
        } else {
            throw new AppException(ErrorCode.LIST_REQUEST_EMPTY);
        }
    }

    @Transactional
    @Override
    public Integer updateList(List<UserDtoRequest> userDtoRequestList) {
        if (!userDtoRequestList.isEmpty()) {
            var entityList = UserConvert.convertListDtoRequestToListEntity(userDtoRequestList);
            List<User> insertList = new ArrayList<>();
            List<User> updateList = new ArrayList<>();
            for (User user : entityList) {
                if (userMapper.isExist(user.getUsername()) == 1) {
                    log.info("Tìm thấy user" + user.getUsername());
                    updateList.add(user);
                } else {
                    log.info("Không thấy user" + user.getUsername());
                    insertList.add(user);
                }
            }
            Integer rows = 0;
            if (!updateList.isEmpty()) {
                log.info(">>>START UPDATING USER LIST");
                for(User u : updateList){
                    rows += userMapper.update(u);
                }
            }
            if (!insertList.isEmpty()) {
                log.info(">>>START INSERTING USER LIST");
                rows += userMapper.insertList(insertList);
            }
            return rows;
        } else {
            throw new AppException(ErrorCode.LIST_REQUEST_EMPTY);
        }
    }

    @Transactional
    @Override
    public Integer saveList(List<UserDtoRequest> userDtoRequestList) {
        if (!userDtoRequestList.isEmpty()) {
            var entityList = UserConvert.convertListDtoRequestToListEntity(userDtoRequestList);
            return userMapper.saveList(entityList);
        } else {
            throw new AppException(ErrorCode.LIST_REQUEST_EMPTY);
        }
    }

    @Override
    public Integer deleteList(List<String> usernameList) {
        if (!usernameList.isEmpty()) {
            return userMapper.deleteList(usernameList);
        } else {
            throw new AppException(ErrorCode.LIST_REQUEST_EMPTY);
        }
    }

}
