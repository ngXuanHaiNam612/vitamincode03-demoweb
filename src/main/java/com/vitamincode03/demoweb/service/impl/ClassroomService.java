package com.vitamincode03.demoweb.service.impl;

import com.vitamincode03.demoweb.entity.Classroom;
import com.vitamincode03.demoweb.mapper.ClassroomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassroomService {

    @Autowired
    private final ClassroomMapper classroomMapper;

    public void findAllClass(){
        System.out.println("Danh sách lớp: ");
        List<Classroom> resultList = classroomMapper.findAll();
        for (Classroom classroom : resultList) {
            System.out.println("+ " + classroom.getName());
        }
    }

    public void findClassById(int id){
        Classroom result = classroomMapper.findById(id);
        System.out.println("+ " + result.getName());
    }

    public int insertClassroom(Classroom classroom) {
        System.out.println("Insert " + classroom.getName());
        classroomMapper.insert(classroom);
        System.out.println("Successfully inserted " + classroom.getName());
        return 0;

    }

}
