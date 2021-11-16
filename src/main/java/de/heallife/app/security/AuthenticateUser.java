package de.heallife.app.security;

import de.heallife.app.data.QehrgUser;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;

public class AuthenticateUser {

    @Bean
    private void authenticateUser(String email, String password) {
        UserDetails user = User.withUsername(email).password(password).roles("USER").build();
        new InMemoryUserDetailsManager(user);
    }


}
