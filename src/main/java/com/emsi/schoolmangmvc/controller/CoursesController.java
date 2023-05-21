package com.emsi.schoolmangmvc.controller;


import com.emsi.schoolmangmvc.repositories.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoursesController {

    @Autowired
    private CoursesRepository coursesRepository;

    @GetMapping("/user/course")
    public String course(){
        return "course";
    }
}
