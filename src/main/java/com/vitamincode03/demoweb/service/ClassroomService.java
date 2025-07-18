package com.vitamincode03.demoweb.service;

import com.vitamincode03.demoweb.entity.Classroom;
import com.vitamincode03.demoweb.mapper.ClassroomMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClassroomService {
    private ClassroomMapper classroomMapper;

    public void findAll() {
        try {
            List<Classroom> list = classroomMapper.findAll();
            System.out.println("=== Danh sách lớp học ===");
            list.forEach(System.out::println);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }




}
