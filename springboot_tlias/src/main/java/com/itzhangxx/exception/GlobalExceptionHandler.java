package com.itzhangxx.exception;

import com.itzhangxx.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
* 全局异常处理器
* */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class) //所有异常
    public Result ex(Exception ex){
        ex.printStackTrace();
        return Result.error("操作失败");

    }

}
