package com.example.springboot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "app")
@Data
public class AppConfig {
    private String name;
    private String version;
    private String description;
    private List<String> envs;
    private Author author;
    private Integer tokens;
    private Boolean enabled = true;


    @Data
    public static class Author {
        private String name;
        private String website;
        private String email;
    }
}
