package ru.diszexuf.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.diszexuf.webshop.model.User;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    void deleteUserByEmail(String email);
    User findUserByEmail(String email);
    Optional<User> findByUsername(String username);
}
