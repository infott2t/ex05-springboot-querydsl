package org.example.config.auth.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.domain.user.User;

import java.io.Serializable;

@Getter
@Setter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    private String role;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
        this.role = String.valueOf(user.getRole());
    }
}