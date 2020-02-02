package pl.cinema.cinema_project.controllers.login;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginForm {

    private String username;
    private String password;

    public LoginForm(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
