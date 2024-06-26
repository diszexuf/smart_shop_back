package ru.diszexuf.webshop.dto;

import lombok.Data;

@Data
public class RegistrationDTO {

    private String username;
    private String password;

    public String toString() {
        return "Registration info: username" + this.username + " password: " + this.password;
    }

}
