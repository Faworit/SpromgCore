package com.epam.ryabtsev.DAO.impl;

import com.epam.ryabtsev.DAO.UserDAO;
import com.epam.ryabtsev.DAO.storage.Storage;
import com.epam.ryabtsev.model.User;
import com.epam.ryabtsev.model.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserDAOImpl implements UserDAO {

    private Storage storage;

    public UserDAOImpl(Storage storage) {
        this.storage = storage;
    }


    @Override
    public User getUserById(long userId) {
        return storage.getUserById(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return storage.getUserByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {

        return storage.getUsersByName(name, pageSize, pageNum);
    }

    @Override
    public User createUser(User user) {
        return storage.createUser(user);
    }

    @Override
    public User updateUser(User user) {
        return storage.updateUser(user);
    }

    @Override
    public boolean deleteUser(long userId) {
        return storage.deleteUser(userId);
    }
}
