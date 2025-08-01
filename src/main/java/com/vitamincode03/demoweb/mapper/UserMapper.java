package com.vitamincode03.demoweb.mapper;

import com.vitamincode03.demoweb.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> findAll();
    public List<User> findByUsername(@Param("username") String username);

    public int insert(User user);
}
