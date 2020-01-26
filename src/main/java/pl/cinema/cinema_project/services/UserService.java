package pl.cinema.cinema_project.services;


import org.springframework.security.core.userdetails.UserDetailsService;
import pl.cinema.cinema_project.models.User;

public interface UserService extends UserDetailsService {
    // Własne metody
    void save(User user);

    boolean isUniqueLogin(String login);
}
