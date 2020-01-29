package pl.cinema.cinema_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.cinema.cinema_project.models.Role;
import pl.cinema.cinema_project.models.User;
import pl.cinema.cinema_project.repositories.RoleRepository;
import pl.cinema.cinema_project.repositories.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public void save(User user) {
        Role userRole = roleRepository.findRoleByType(Role.Types.ROLE_MOD);
        List roles = Arrays.asList(userRole);
        //user.setRoles(new HashSet<>(roles));
        user.setPassword(user.getPassword());
        user.setPasswordConfirm(null);//wyzerowanie jest potrzebne ze względu na walidację adnotacjami hibernate
        userRepository.saveAndFlush(user);
    }

    @Override
    public boolean isUniqueLogin(String login) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}