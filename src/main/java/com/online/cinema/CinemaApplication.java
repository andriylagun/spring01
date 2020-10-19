package com.online.cinema;

import com.online.cinema.config.ApplicationConfig;
import com.online.cinema.entity.User;
import com.online.cinema.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CinemaApplication {
    private static final Logger logger = Logger.getLogger(CinemaApplication.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UserService userService = context.getBean(UserService.class);

        userService.add(User.builder().name("Bob")
                .email("bob123@gmail.com")
                .password("12345")
                .build());
        userService.add(User.builder().name("Alice")
                .email("alice@gmail.com")
                .password("12345")
                .build());
        userService.add(User.builder().name("John")
                .email("john@gmail.com")
                .password("12345")
                .build());

        userService.listUsers().forEach(logger::info);
    }

}
