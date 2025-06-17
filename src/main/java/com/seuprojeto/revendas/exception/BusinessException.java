package com.seuprojeto.revendas.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class BusinessException  extends RuntimeException{

    private String detail;
    private String title;
    private String code;
    private List<String> errors;

    public BusinessException(String detail, String title, String code) {
        this.detail = detail;
        this.title = title;
        this.code = code;
    }

    public BusinessException(String detail, String title,String code, List<String> errors) {
        this.detail = detail;
        this.title = title;
        this.code = code;
        this.errors = errors;

    }



}
