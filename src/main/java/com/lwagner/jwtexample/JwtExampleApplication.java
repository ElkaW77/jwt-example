package com.lwagner.jwtexample;

import com.lwagner.jwtexample.domain.AppUser;
import com.lwagner.jwtexample.domain.Role;
import com.lwagner.jwtexample.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class JwtExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtExampleApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new AppUser(null, "Leonard Wagner", "ElkaW", "1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Arnold Schwarzenegger", "Arni", "arnold", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Tom Holland", "Tommy", "spidy", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Mark Janitschek", "Raaamk", "ramk", new ArrayList<>()));

            userService.addRoleToUser("ElkaW", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("ElkaW", "ROLE_ADMIN");
            userService.addRoleToUser("ElkaW", "ROLE_USER");
            userService.addRoleToUser("Arni", "ROLE_ADMIN");
            userService.addRoleToUser("Arni", "ROLE_MANAGER");
            userService.addRoleToUser("Tommy", "ROLE_MANAGER");
            userService.addRoleToUser("Raaamk", "ROLE_USER");
        };
    }
}
