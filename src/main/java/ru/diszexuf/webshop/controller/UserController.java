package ru.diszexuf.webshop.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.diszexuf.webshop.model.User;
import ru.diszexuf.webshop.service.IUserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping("save_user")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{email}")
    public User findByName(@PathVariable String email) {
        return userService.findUserByEmail(email);
    }

    @PutMapping("update_user")
    public User updateUser(User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("delete_user/{email}")
    public void deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
    }

    @GetMapping("/all")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

//    @GetMapping("/user")
//    public OAuth2User user(@AuthenticationPrincipal OAuth2User principal) {
//        return principal;
//    }
}
