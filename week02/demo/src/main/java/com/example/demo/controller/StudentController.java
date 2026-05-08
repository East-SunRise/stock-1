package com.example.demo.controller;

import jakarta.annotation.Resource;
import com.example.demo.entity.Student ;
import com.example.demo.service.StudentService ;
import com.example.demo.vo.StudentVO ;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

    @RestController
    @RequestMapping("/api/v1/student")

    public class StudentController {
        @Resource
        private StudentService studentService;

        @GetMapping("/all")
        public Collection<StudentVO> getAllStudents () {
            Collection<Student> students = studentService.getAllStudents();
            return students.stream()
                    .map(student -> StudentVO.builder()
                            .id(student.getId())
                            .name(student.getName())
                            .gender(student.getGender())
                            .mobile(student.getMobile())
                            .createTime(student.getCreateTime())
                            .build())
                    .collect(Collectors.toList());
        }
    }
