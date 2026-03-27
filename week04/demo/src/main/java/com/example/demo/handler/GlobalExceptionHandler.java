package com.example.demo.handler;

import com.example.demo.common.Result;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



import java.util.StringJoiner;


@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<?> handleValidation(MethodArgumentNotValidException e) {
        StringJoiner sj = new StringJoiner("; ");
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            sj.add(fieldError.getDefaultMessage());
        }
        return Result.error(400, sj.toString());
    }


    @ExceptionHandler(BusinessException.class)
    public Result<?> handleBusinessException(BusinessException e) {
        return Result.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result<?> handleException(Exception e) {
        // 实际生产环境建议记录日志
        // log.error("系统异常", e);
        return Result.error(500, "服务器异常，请稍后重试");
    }
}
