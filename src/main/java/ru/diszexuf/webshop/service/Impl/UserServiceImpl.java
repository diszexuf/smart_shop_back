package ru.diszexuf.webshop.service.Impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.diszexuf.webshop.model.User;
import ru.diszexuf.webshop.repository.IUserRepository;
import ru.diszexuf.webshop.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Primary
public class UserServiceImpl implements UserService, UserDetailsService {
    private final IUserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User updateUser(User user) {
        User editUser = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + user.getUsername()));
        editUser.setFullName(user.getFullName());
        editUser.setPhone(user.getPhone());
        editUser.setEmail(user.getEmail());

        return userRepository.save(editUser);
    }

//    @Override
//    @Transactional
//    public void deleteUser(String email) {
//        userRepository.deleteUserByEmail(email);
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user isn't valid"));
    }
}
