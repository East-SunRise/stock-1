
package top.mqxu.week09.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/test")
    public String test() {
        log.info("执行 TestController.test() 方法");
        return "hello test!!!";
    }

    @GetMapping("/admin")
    public String admin() {
        log.info("执行 TestController.admin() 方法 - 管理员接口");
        return "{\"code\": 200, \"message\": \"管理员接口访问成功\", \"data\": \"admin data\"}";
    }

    @GetMapping("/public")
    public String publicApi() {
        log.info("执行 TestController.publicApi() 方法 - 公共接口");
        return "{\"code\": 200, \"message\": \"公共接口访问成功\", \"data\": \"public data\"}";
    }

    @GetMapping("/health")
    public String health() {
        log.info("执行 TestController.health() 方法 - 健康检查");
        return "{\"code\": 200, \"message\": \"健康检查通过\", \"status\": \"UP\"}";
    }
}
