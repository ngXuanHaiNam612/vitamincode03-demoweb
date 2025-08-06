package com.vitamincode03.demoweb.mapper;

import com.vitamincode03.demoweb.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> findAll();
    public List<User> findByUsername(@Param("username") String username);
    public List<User> findByUsernameList(@Param("usernameList") List<String> usernameList);
    public Integer insert(User user);
    public Integer insertList (@Param("list")List<User> userList);
    public Integer update(User user);

}
