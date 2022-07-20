package com.lianglliu.springbootevents.springevents.listener;

import com.lianglliu.springbootevents.springevents.domain.User;
import com.lianglliu.springbootevents.springevents.events.UserCreateEvent;
import com.lianglliu.springbootevents.springevents.service.UserService;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreateEventListener implements ApplicationListener<UserCreateEvent> {

    private final UserService userService;

    public UserCreateEventListener(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(UserCreateEvent event) {
        Long userId = event.getUserId();
        User user = userService.findById(userId);
        sendEmail(user);
    }

    private void sendEmail(User user) {
        System.out.println("给用户 " + user.getUsername() + " 发送邮件.");
    }
}
