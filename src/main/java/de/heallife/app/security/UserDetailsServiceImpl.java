package de.heallife.app.security;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import de.heallife.app.data.QehrgUser;
import de.heallife.app.data.entity.User;
import de.heallife.app.data.service.QehrgUserRepository;
import de.heallife.app.data.service.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private QehrgUserRepository userRepository;

    private QehrgUser user;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        user = userRepository.findByCustomQuery(username);

        if (user == null) {

            user = userRepository.findByCustomQueryEmail(username);

            if (user == null) {

                throw new UsernameNotFoundException("No user present with username: " + username);
            }
        }
            return new org.springframework.security.core.userdetails.User(user.getUserLogin(), user.getUserPass(), Collections.singleton(new SimpleGrantedAuthority("ROLE_" + "USER")));

    }

}
