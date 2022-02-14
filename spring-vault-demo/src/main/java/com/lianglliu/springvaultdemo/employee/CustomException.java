package com.lianglliu.springvaultdemo.employee;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString
public class CustomException extends RuntimeException {

    private String statusType;
    private String message;

    public CustomException(String statusType, String message) {
        super(message);
        this.statusType = statusType;
        this.message = message;
    }
}