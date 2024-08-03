package com.avazhenin.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
class GlobalDefaultExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        Map<String, Object> err = new LinkedHashMap<>();
        err.put("requested-url", req.getRequestURI());
        err.put("timestamp", LocalDateTime.now());
        err.put("error", e.getMessage());
        err.put("cause", e.getCause().getCause());
        return new ResponseEntity(err, HttpStatus.BAD_REQUEST);
    }
}
