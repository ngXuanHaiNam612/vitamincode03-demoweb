package com.vitamincode03.demoweb.service;

import com.vitamincode03.demoweb.dto.request.UserDtoRequest;
import com.vitamincode03.demoweb.dto.response.UserDtoResponse;

import java.util.List;

public interface UserService {
    // Tìm tất cả user
    List<UserDtoResponse> findAll();
    // Tìm user theo usernamme
    UserDtoResponse findByUsername(String username);
    // Tìm danh sách user theo username
    List<UserDtoResponse> findByUsernameList(List<String> usernameList);
    // Thêm user (một hoặc nhiều)
    Integer insertList(List<UserDtoRequest> userDtoRequestList);
    // Cập nhật user (một hoặc nhiều)
    Integer updateList(List<UserDtoRequest> userDtoRequestList);
    // Lưu(Thêm/Cập nhật) user (một hoặc nhiều)
    Integer saveList(List<UserDtoRequest> userDtoRequestList);
    // Xóa user ng username (một hoặc nhiều)
    Integer deleteList(List<String> usernameList);
}
