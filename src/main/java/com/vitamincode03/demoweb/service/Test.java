package com.vitamincode03.demoweb.service;


import com.vitamincode03.demoweb.DemoWebApplication;
import com.vitamincode03.demoweb.entity.Classroom;
import com.vitamincode03.demoweb.mapper.ClassroomMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class Test   {

    public static void main(String[] args) {
        // Khởi động Spring context thủ công
        ApplicationContext context = SpringApplication.run(DemoWebApplication.class, args);
        // Lấy bean từ context
        ClassroomService classroomService = context.getBean(ClassroomService.class);
        classroomService.findAll();
    }


}
