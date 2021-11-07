package com.epam.ryabtsev.service.impl;

import com.epam.ryabtsev.model.User;
import com.epam.ryabtsev.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public User getUserById(long userId) {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public boolean deleteUser(long userId) {
        return false;
    }
}
