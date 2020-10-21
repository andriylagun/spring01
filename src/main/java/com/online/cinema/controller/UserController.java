package com.online.cinema.controller;

import com.online.cinema.dto.UserResponseDto;
import com.online.cinema.entity.User;
import com.online.cinema.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RequestMapping("/user")
@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/inject")
    public RedirectView injectUsers() {
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
        userService.add(User.builder().name("Anastasia")
                .email("anastasia@gmail.com")
                .password("12345")
                .build());
        return new RedirectView("/user");
    }

    @GetMapping("/{userId}")
    public UserResponseDto get(@PathVariable Long userId) {
        User user = userService.get(userId);
        return getDtoFromUser(user);
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.listUsers().stream()
                .map(this::getDtoFromUser)
                .collect(Collectors.toList());
    }

    private UserResponseDto getDtoFromUser(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setName(user.getName());
        responseDto.setEmail(user.getEmail());
        return responseDto;
    }
}
