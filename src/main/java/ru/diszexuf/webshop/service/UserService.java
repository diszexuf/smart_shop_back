package ru.diszexuf.webshop.service;

import ru.diszexuf.webshop.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUsers();
    User saveUser(User user);
    Optional<User> findUserByUsername(String username);
    User updateUser(User user);
    void deleteUser(String email);
}
