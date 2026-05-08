package com.example.springboot.conroller;

import com.example.springboot.common.Result;
import com.example.springboot.config.AppConfig;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/config")
public class BaseConfigController {
    @Value("${server.port}")
    private Integer port;

    @Value("${server.servlet.context-path:/}")
    private String contextPath;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${app.name}")
    private String appName;

    @Value("${app.version: 1.0.0}")
    private String Version;

    @Value("${app.description}")
    private String description;

    @Resource
    private AppConfig appConfig;



    @GetMapping("/info")
    public Result<Map<String, Object>> getConfigInfoSimple() {
        Map<String, Object> map = Map.of(
                "port", port,
                "contextPath", contextPath,
                "applicationName", applicationName,
                "appName", appConfig.getName(),
                "Version", appConfig.getVersion(),
                "description", appConfig.getDescription()
        );
        return Result.success(map);
    }
}


