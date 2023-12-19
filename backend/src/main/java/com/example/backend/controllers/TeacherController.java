package com.example.backend.controllers;

import com.example.backend.models.LanguageLearner;
import com.example.backend.models.Teacher;
import com.example.backend.requests.TeacherAddRequest;
import com.example.backend.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/{userId}")
    public Teacher getTeacherById(@PathVariable Long userId) {
        return teacherService.getTeacherById(userId);
    }

    @GetMapping()
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @PostMapping()
    public void addTeacher(@RequestBody TeacherAddRequest request) {
        teacherService.addTeacher(request);
    }

}
