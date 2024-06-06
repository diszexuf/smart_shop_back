package ru.diszexuf.webshop.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.diszexuf.webshop.dto.LoginResponseDTO;
import ru.diszexuf.webshop.dto.RegistrationDTO;
import ru.diszexuf.webshop.model.User;
import ru.diszexuf.webshop.service.Impl.AuthenticationService;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuhenticationController {

    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public User registerUser(@RequestBody RegistrationDTO body) {
        return authenticationService.registerUser(body.getUsername(), body.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body) {
        return  authenticationService.loginUser(body.getUsername(), body.getPassword());
    }
}
