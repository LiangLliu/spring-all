package com.lianglliu.springbootevents;

import com.lianglliu.springbootevents.springevents.domain.User;
import com.lianglliu.springbootevents.springevents.rest.request.UserRequest;
import com.lianglliu.springbootevents.springevents.service.UserService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootEventsApplication implements ApplicationRunner {

	private final UserService userService;

	public SpringBootEventsApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEventsApplication.class, args);
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		User user = userService.create(new UserRequest("张三"));
		userService.deleteById(user.getId());
	}
}
