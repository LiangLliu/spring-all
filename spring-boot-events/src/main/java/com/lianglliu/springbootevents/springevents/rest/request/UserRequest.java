package com.lianglliu.springbootevents.springevents.rest.request;

import javax.validation.constraints.NotBlank;

public class UserRequest {

    @NotBlank(message = "用户名不能为空")
    private String username;

    public UserRequest() {
    }

    public UserRequest(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
