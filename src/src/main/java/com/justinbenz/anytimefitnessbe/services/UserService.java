package com.justinbenz.anytimefitnessbe.services;

import com.justinbenz.anytimefitnessbe.models.User;

import java.util.List;

public interface UserService {
    User save(User user);

    List<User> findAll();

    User findUserById(long id);
}
