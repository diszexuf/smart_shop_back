package ru.diszexuf.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.diszexuf.webshop.model.User;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    void deleteUserByEmail(String email);

//    @Query("SELECT u FROM User u LEFT JOIN FETCH u.authorities WHERE u.username = :username")
    @Query("SELECT u FROM User u LEFT JOIN FETCH u.authorities WHERE u.username = :username")
    Optional<User> findByUsername(@Param("username") String username);
}
