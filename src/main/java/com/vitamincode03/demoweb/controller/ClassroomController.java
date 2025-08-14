package com.vitamincode03.demoweb.controller;

import com.vitamincode03.demoweb.entity.Classroom;
import com.vitamincode03.demoweb.service.impl.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/classrooms")
@RequiredArgsConstructor
public class ClassroomController {

    @Autowired
    private final ClassroomService classroomService;

    @GetMapping()
    void doGetAllClassroom(){
        classroomService.findAllClass();
    }
    // path variable
    @GetMapping("/get-by-id-v1/{id}")
    void doGetClassroomById1(@PathVariable("id") int id){
        classroomService.findClassById(id);
    }
    // ? key-name = vlue => request param
    @GetMapping("/get-by-id-v2")
    void doGetClassroomById2(@RequestParam("idClassroom") int id){
        classroomService.findClassById(id);
    }

    @PostMapping()
    void createClassroom(@RequestBody Classroom classroom){
        classroomService.insertClassroom(classroom);
    }

}
