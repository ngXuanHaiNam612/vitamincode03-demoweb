package com.vitamincode03.demoweb.mapper;

import com.vitamincode03.demoweb.entity.Classroom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassroomMapper {
    public List<Classroom> findAll();
    public Classroom findById(@Param("classID") int id);
    public int insert(Classroom classroom);
}
