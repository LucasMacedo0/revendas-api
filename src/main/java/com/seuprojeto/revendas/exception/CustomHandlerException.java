package com.seuprojeto.revendas.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class CustomHandlerException {

    // Tratamento  para exceções personalizadas da aplicação ( BusinessException)
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(BusinessException e){
        Map<String , String> response = new HashMap<>();

        response.put("title", e.getTitle());
        response.put("detail", e.getTitle());
        response.put("code", e.getTitle());

        return ResponseEntity.status(Integer.parseInt(e.getCode())).body(response);
    }

}
