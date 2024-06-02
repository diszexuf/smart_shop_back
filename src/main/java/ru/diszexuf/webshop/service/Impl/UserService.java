package ru.diszexuf.webshop.service.Impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.diszexuf.webshop.model.User;
import ru.diszexuf.webshop.repository.IUserRepository;
import ru.diszexuf.webshop.service.IUserService;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class UserService implements IUserService {
    private final IUserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(String email) {
        userRepository.deleteUserByEmail(email);
    }
}
