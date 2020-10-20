package com.online.cinema.service;

import com.online.cinema.entity.User;
import java.util.List;

public interface UserService {
    User add(User user);

    User get(Long id);

    List<User> listUsers();
}
