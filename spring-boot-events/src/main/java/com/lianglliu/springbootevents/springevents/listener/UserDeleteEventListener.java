package com.lianglliu.springbootevents.springevents.listener;

import com.lianglliu.springbootevents.springevents.domain.User;
import com.lianglliu.springbootevents.springevents.events.UserDeleteEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UserDeleteEventListener implements ApplicationListener<UserDeleteEvent> {

    @Override
    public void onApplicationEvent(UserDeleteEvent event) {
        User user = event.getUser();
        System.out.println("删除用户， id: " + user.getId() + "username: " + user.getUsername());
    }
}
