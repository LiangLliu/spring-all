package com.lianglliu.springbootevents.springevents.events;

import org.springframework.context.ApplicationEvent;

public class UserCreateEvent extends ApplicationEvent {
    private Long userId;

    public UserCreateEvent(Long userId) {
        super(userId);
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
