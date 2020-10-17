package com.online.cinema.dao;

import com.online.cinema.entity.User;
import java.util.List;

public interface UserDao {
    User add(User user);

    List<User> listUsers();
}
