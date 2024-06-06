package ru.diszexuf.webshop.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.diszexuf.webshop.model.User;

@Getter
@Setter
public class LoginResponseDTO {

    private User user;
    private String jwt;

    public LoginResponseDTO() {
        super();
    }

    public LoginResponseDTO(User user, String jwt) {
        this.user = user;
        this.jwt = jwt;
    }
}
