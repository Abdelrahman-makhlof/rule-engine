package com.gs1.rule.engine.exception;


import lombok.Getter;

@Getter
public class BusinessException extends Exception {

    private String message;

    public BusinessException(String message) {
        super(message);
    }
}
