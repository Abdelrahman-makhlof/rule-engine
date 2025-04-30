package com.gs1.rule.engine.exception;


import lombok.Getter;

@Getter
public class RuleNotFoundException extends Exception {

    private String message;

    public RuleNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
