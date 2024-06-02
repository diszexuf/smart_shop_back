package ru.diszexuf.webshop.service;

import ru.diszexuf.webshop.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAllUsers();
    User saveUser(User user);
    User findUserByEmail(String emauk);
    User updateUser(User user);
    void deleteUser(String email);
}
