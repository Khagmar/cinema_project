package pl.cinema.cinema_project.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.cinema.cinema_project.models.*;
import pl.cinema.cinema_project.repositories.*;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
public class RepositioriesInitializer {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    //@Autowired
    //private PasswordEncoder passwordEncoder;


    @Bean
    InitializingBean init(){
        return () ->{
            if(roleRepository.findAll().isEmpty() == true)
            {
                try {

                    Role roleAdmin = roleRepository.save(new Role(Role.Types.ROLE_ADMIN));
                    Role roleMod = roleRepository.save(new Role(Role.Types.ROLE_MOD));

                    User admin = new User("admin", true);
                    //admin.setRoles(new HashSet<>(Arrays.asList(roleAdmin)));
                    admin.setPassword("admin");

                    User mod = new User("mod", true);
                    //admin.setRoles(new HashSet<>(Arrays.asList(roleMod)));
                    mod.setPassword("mod");

                    userRepository.save(admin);
                    userRepository.save(mod);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
