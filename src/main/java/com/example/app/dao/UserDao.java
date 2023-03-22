package com.example.app.dao;

import com.example.app.model.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();

    public User fineOne(Long id);

    public void save(User user);

    public void update(Long id, User updatedUser);

    public void delete(Long id);
}
