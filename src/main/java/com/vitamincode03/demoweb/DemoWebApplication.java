package com.vitamincode03.demoweb;

import com.vitamincode03.demoweb.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoWebApplication implements CommandLineRunner {

//    @Autowired
    private ClassroomService classroomService;

    public DemoWebApplication(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoWebApplication.class, args);
    }
    @Override
    public void run(String... args){
        classroomService.findAll();
    }
}
