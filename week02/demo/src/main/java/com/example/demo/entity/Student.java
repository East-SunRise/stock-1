package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import com.example.demo.constant.GenderEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

        private Long id;
        private String name;
        private String avatar;
        private String mobile;
        private GenderEnum gender;
        private boolean enabled;
        private LocalDate birthday;
        private LocalDateTime createTime;

}
