package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.constant.GenderEnum;

import java.util.Collection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    public Collection<Student> getAllStudents () {
        List<Student> students = new ArrayList<>();

        Student student1 = Student.builder()
                .id(1L)
                .name("张三")
                .avatar("https://www.baidu.com")
                .gender(GenderEnum.MALE)
                .birthday(LocalDate.of(1990, 1, 1))
                .enabled(true)
                .mobile("13800138001")
                .createTime(LocalDateTime.now())
                .build();

        Student student2 = Student.builder()
                .id(2L)
                .name("李四")
                .avatar("https://www.baidu.com")
                .gender(GenderEnum.FEMALE)
                .birthday(LocalDate.of(1992, 5, 15))
                .enabled(true)
                .mobile("13800138002")
                .createTime(LocalDateTime.now())
                .build();

        students.add(student1);
        students.add(student2);

        return students;
    }
}
