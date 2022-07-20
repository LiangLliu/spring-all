package com.lianglliu.springbootevents.springevents.events;

import com.lianglliu.springbootevents.springevents.domain.User;
import org.springframework.context.ApplicationEvent;

public class UserDeleteEvent extends ApplicationEvent {
    private User user;

    public UserDeleteEvent(User user) {
        super(user);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
