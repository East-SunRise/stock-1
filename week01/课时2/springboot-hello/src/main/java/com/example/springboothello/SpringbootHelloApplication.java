package com.example.springboothello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example", "controller", "vo"})
public class SpringbootHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHelloApplication.class, args);
    }

}
