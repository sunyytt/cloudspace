package com.example.springclouduser.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: sunyy
 * @Date: 2018/11/13 17:32
 * @Description:
 * 针对异常做统一处理
 */

//@ControllerAdvice
//@ResponseBody
public class MyExceptionHandle {
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<String> handleException(Exception e){
//        return new ResponseEntity (e.getMessage () , HttpStatus.OK) ;
//    }
}
