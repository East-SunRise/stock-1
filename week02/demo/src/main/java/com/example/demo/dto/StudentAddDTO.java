package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import com.example.demo.constant.GenderEnum;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentAddDTO {
    private String name;
    private String mobile;
    private GenderEnum gender;
    private String avatar;
    private LocalDate birthday;
}
