package com.example.backend.services;

import com.example.backend.models.Teacher;
import com.example.backend.repositories.LanguageLearnerRepository;
import com.example.backend.repositories.TeacherRepository;
import com.example.backend.repositories.UserRepository;
import com.example.backend.requests.TeacherAddRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final UserRepository userRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository, UserRepository userRepository) {
        this.teacherRepository = teacherRepository;
        this.userRepository = userRepository;
    }

    public Teacher getTeacherById(Long userId) {
        return teacherRepository.getTeacherById(userId);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.getAllTeachers();
    }

    public void addTeacher(TeacherAddRequest request) {
        if (request == null || !userRepository.existsById(request.getUserId())) {
            throw new RuntimeException("User id is null or user does not exist while adding a teacher");
        }

        Teacher teacher = new Teacher();
        teacher.setUserId(request.getUserId());
        teacher.setSessionPricePerHour(request.getSessionPricePerHour());
        teacher.setIsApproved(request.getIsApproved());
        teacher.setRequestDate(request.getRequestDate());
        teacher.setResponseDate(request.getResponseDate());
//        teacher.setActivationAdminId(request.getActivationAdminId());

        teacherRepository.addTeacher(teacher);
    }
}
