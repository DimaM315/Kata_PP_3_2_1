package com.example.app.service;

import com.example.app.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();
    User getOne(Long id);
    public void save(User user);
    public void update(Long id, User updatedUser);
    public void delete(Long id);
}
