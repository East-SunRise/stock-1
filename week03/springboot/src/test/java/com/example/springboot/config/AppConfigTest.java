package com.example.springboot.config;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class AppConfigTest {
    @Resource
    private AppConfig appConfig;

    @Test
    void getName() {
        log.info("APP名: {}", appConfig.getName());
    }

    @Test
    void getVersion() {
        log.info("版本号: {}", appConfig.getVersion());
    }

    @Test
    void getDescription() {
        log.info("描述名: {}", appConfig.getDescription());
    }
}