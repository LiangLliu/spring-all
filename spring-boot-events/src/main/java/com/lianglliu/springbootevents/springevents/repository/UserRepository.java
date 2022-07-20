package com.lianglliu.springbootevents.springevents.repository;

import com.lianglliu.springbootevents.springevents.domain.User;
import com.lianglliu.springbootevents.springevents.utils.IDGenerator;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private static final List<User> users;

    static {
        users = new ArrayList<>();
    }

    public User create(User user) {
        long id = IDGenerator.getId();
        var newUser = new User(id, user.getUsername());
        users.add(newUser);
        return newUser;
    }

    public Optional<User> findById(Long id) {
        return users.stream()
                .filter(it -> it.getId().equals(id))
                .findFirst();
    }

    public void deleteById(Long id) {
        users.stream()
                .filter(it -> it.getId().equals(id))
                .findFirst()
                .ifPresent(users::remove);
    }
}
