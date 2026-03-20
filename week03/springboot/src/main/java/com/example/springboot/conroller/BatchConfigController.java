package com.example.springboot.conroller;


import com.example.springboot.common.Result;
import com.example.springboot.config.AppConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("config/batch")
@RequiredArgsConstructor
public class BatchConfigController {
    private final AppConfig appConfig;

    @GetMapping("info")
    public Result<AppConfig> getConfigInfoBatch() {
        return Result.success(appConfig);
    }
}
