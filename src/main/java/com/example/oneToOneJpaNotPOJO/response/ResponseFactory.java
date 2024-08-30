package com.example.oneToOneJpaNotPOJO.response;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@Component
public class ResponseFactory {

//    @Autowired
//    HttpServletRequest request;
    public ResponseEntity<Basic> buildError(HttpStatus status, String duration, Object result, String errorCode, String message) {

        Basic basic = new Basic(false,duration,message,errorCode,result);
        return ResponseEntity.status(status).body(basic);
    }

    public ResponseEntity<Basic> buildSuccess(HttpStatus status,String duration, Object result, String errorCode, String message) {

        Basic basic = new Basic(true,duration,message,errorCode,result);

        return ResponseEntity.status(status).body(basic);
    }
}