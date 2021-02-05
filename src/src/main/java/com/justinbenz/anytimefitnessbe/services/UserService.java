package com.justinbenz.anytimefitnessbe.services;

import com.justinbenz.anytimefitnessbe.models.User;

import java.util.List;

public interface UserService {
    User save(User user);

    User update(User user, long id);

    User findByName(String name);

    List<User> findAll();

    User findUserById(long id);

    void delete(long id);
}
