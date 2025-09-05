package com.vitamincode03.demoweb.controller;

import com.vitamincode03.demoweb.common.ApiConstraints;
import com.vitamincode03.demoweb.dto.request.UserDtoRequest;
import com.vitamincode03.demoweb.dto.response.ApiResponse;
import com.vitamincode03.demoweb.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(ApiConstraints.ApiUser.BASE)

@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserServiceImpl userService;

    @GetMapping(ApiConstraints.ApiUser.GET_ALL_USER)
    ApiResponse<?> doGetAllUser() {
        return ApiResponse.builder()
                .statusCode(200)
                .success(Boolean.TRUE)
                .message("Call API Success")
                .data(userService.findAll())
                .build();
    }

    @GetMapping(ApiConstraints.ApiUser.GET_BY_USERNAME)
    ApiResponse<?> doGetByUsername(@RequestParam(name= "username", required = false) String username) {
        return ApiResponse.builder()
                .statusCode(200)
                .success(Boolean.TRUE)
                .message("Call API Success")
                .data(userService.findByUsername(username))
                .build();
    }

    @GetMapping(ApiConstraints.ApiUser.GET_BY_LIST_USERNAME)
    ApiResponse<?> doGetByListUsername(@RequestBody List<String> usernameList) {
        return ApiResponse.builder()
                .statusCode(200)
                .success(Boolean.TRUE)
                .message("Call API Success")
                .data(userService.findByUsernameList(usernameList))
                .build();
    }

    @PostMapping(ApiConstraints.ApiUser.CREATE)
    ApiResponse<Integer> doCreateListUser(@RequestBody List<UserDtoRequest> userDtoRequestList) {
        return ApiResponse.<Integer>builder()
                .statusCode(200)
                .success(Boolean.TRUE)
                .message("Call API Success")
                .data(userService.insertList(userDtoRequestList))
                .build();
    }

    @PutMapping(ApiConstraints.ApiUser.UPDATE)
    ApiResponse<Integer> doUpdateListUser(@RequestBody List<UserDtoRequest> userDtoRequestList) {
        return ApiResponse.<Integer>builder()
                .statusCode(200)
                .success(Boolean.TRUE)
                .message("Call API Success")
                .data(userService.updateList(userDtoRequestList))
                .build();
    }

    @PutMapping(ApiConstraints.ApiUser.SAVE)
    ApiResponse<Integer> doSaveListUser(@RequestBody List<UserDtoRequest> userDtoRequestList) {
        return ApiResponse.<Integer>builder()
                .statusCode(200)
                .success(Boolean.TRUE)
                .message("Call API Success")
                .data(userService.saveList(userDtoRequestList))
                .build();
    }


    @DeleteMapping(ApiConstraints.ApiUser.DELETE)
    ApiResponse<Integer> doDeleteListUser(@RequestBody List<String> usernameList) {
        return ApiResponse.<Integer>builder()
                .statusCode(200)
                .success(Boolean.TRUE)
                .message("Call API Success")
                .data(userService.deleteList(usernameList))
                .build();
    }
}
