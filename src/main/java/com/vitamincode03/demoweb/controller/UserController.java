package com.vitamincode03.demoweb.controller;

import com.vitamincode03.demoweb.dto.request.UserDtoRequest;
import com.vitamincode03.demoweb.dto.response.ApiResponse;
import com.vitamincode03.demoweb.dto.response.UserDtoResponse;
import com.vitamincode03.demoweb.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserServiceImpl userService;

    @GetMapping("/get-all-user")
    ApiResponse<?> doGetAllUser() {
        return ApiResponse.builder()
                .statusCode(200)
                .success(Boolean.TRUE)
                .message("Gọi api thành công")
                .data(userService.findAll())
                .build();
    }

    @GetMapping("/get-by-username")
    ApiResponse<?> doGetByUsername(@RequestParam(name= "username", required = false) String username) {
        return ApiResponse.builder()
                .statusCode(200)
                .success(Boolean.TRUE)
                .message("Gọi api thành công")
                .data(userService.findByUsername(username))
                .build();
    }

    @GetMapping("/get-list-user")
    ApiResponse<?> doGetByUsernameList(@RequestBody List<String> usernameList) {
        return ApiResponse.builder()
                .statusCode(200)
                .success(Boolean.TRUE)
                .message("Gọi api thành công")
                .data(userService.findByUsernameList(usernameList))
                .build();
    }

    @GetMapping("/login")
    ApiResponse<UserDtoResponse> doLogin(@RequestBody UserDtoRequest userDtoRequest) {
        return ApiResponse.<UserDtoResponse>builder()
                .statusCode(200)
                .success(Boolean.TRUE)
                .message("Gọi api thành công")
                .data(userService.login(userDtoRequest))
                .build();
    }

    @PostMapping("/create-list")
    ApiResponse<Integer> doCreateListUser(@RequestBody List<UserDtoRequest> userDtoRequestList) {
        return ApiResponse.<Integer>builder()
                .statusCode(200)
                .success(Boolean.TRUE)
                .message("Gọi api thành công")
                .data(userService.insertList(userDtoRequestList))
                .build();
    }

    @PostMapping("/save")
    ApiResponse<Integer> doSaveUser(@RequestBody UserDtoRequest userDtoRequest) {
        return ApiResponse.<Integer>builder()
                .statusCode(200)
                .success(Boolean.TRUE)
                .message("Gọi api save thành công")
                .data(userService.save(userDtoRequest))
                .build();
    }

    @PostMapping("/save-list")
    ApiResponse<Integer> doSaveListUser(@RequestBody List<UserDtoRequest> userDtoRequestList) {
        return ApiResponse.<Integer>builder()
                .statusCode(200)
                .success(Boolean.TRUE)
                .message("Gọi api save thành công")
                .data(null)
                .build();
    }
}
