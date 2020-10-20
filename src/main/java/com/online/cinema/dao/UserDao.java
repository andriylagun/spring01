package com.online.cinema.dao;

import com.online.cinema.entity.User;
import java.util.List;

public interface UserDao {
    User add(User user);

    User get(Long id);

    List<User> listUsers();
}
