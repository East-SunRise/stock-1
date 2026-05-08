package com.example.demo.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Student {
    private long id;
    private String name;

    public void study() {
        log.info("学生{}正在学习", name);
    }
}