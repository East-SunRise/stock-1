package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.Team;
import com.example.demo.handler.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/team")
@Slf4j
public class TeamController {
    @PostMapping("/add")
    public Result<String> addTeam(@Validated @RequestBody Team team, HttpServletRequest request){
        log.info("add team:{}", team);
        String token = request.getHeader("token");
        if(token == null || token.isBlank()){
           throw new BusinessException(401, "请先登录");
        }
        if(!"admin".equals(token)){
            throw new BusinessException(401, "token无效");
        }
        return Result.success("添加成功");
    }
}
