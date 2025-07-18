package com.vitamincode03.demoweb.mapper;

import com.vitamincode03.demoweb.entity.Classroom;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassroomMapper {
    List<Classroom> findAll();

}
