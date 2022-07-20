package com.lianglliu.springbootevents.springevents.service;

import com.lianglliu.springbootevents.springevents.domain.User;
import com.lianglliu.springbootevents.springevents.events.UserCreateEvent;
import com.lianglliu.springbootevents.springevents.events.UserDeleteEvent;
import com.lianglliu.springbootevents.springevents.repository.UserRepository;
import com.lianglliu.springbootevents.springevents.rest.request.UserRequest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public UserService(UserRepository userRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.userRepository = userRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public User create(UserRequest request) {
        User user = userRepository.create(new User(request.getUsername()));
        applicationEventPublisher.publishEvent(new UserCreateEvent(user.getId()));
        return user;
    }

    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("not found user"));
    }

    public void deleteById(Long userId) {
        User user = findById(userId);
        applicationEventPublisher.publishEvent(new UserDeleteEvent(user));
        userRepository.deleteById(userId);
    }
}
