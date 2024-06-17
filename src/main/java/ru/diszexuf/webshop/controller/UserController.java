package ru.diszexuf.webshop.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.diszexuf.webshop.model.User;
import ru.diszexuf.webshop.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("save_user")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/find_{username}")
    public Optional<User> findByName(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }

    @PutMapping(value = "/update_user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

//    @DeleteMapping("/delete_user/{email}")
//    public void deleteUser(@PathVariable String email) {
//        userService.deleteUser(email);
//    }

    @GetMapping("/all")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

}
