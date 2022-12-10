package de.wpwa.app.security;

import de.wpwa.app.data.User;
import de.wpwa.app.data.service.SubscriptionManagement;
import de.wpwa.app.data.service.UserRepository;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired private UserRepository userRepository;
  @Autowired private SubscriptionManagement service;

  private User user;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    user = userRepository.findByCustomQuery(username);

    if (user == null) {

      user = userRepository.findByCustomQueryEmail(username);

      if (user == null) {

        throw new UsernameNotFoundException("No user present with username: " + username);
      }
    }

    if (subscriptionActive(user)) {
      return new org.springframework.security.core.userdetails.User(
          user.getUserLogin(),
          user.getUserPass(),
          Collections.singleton(new SimpleGrantedAuthority("ROLE_" + "USER")));
    } else {
      throw new UsernameNotFoundException("Subscription is not active");
    }
  }

  private boolean subscriptionActive(User user) {
    return service.isSubscriptionActive(user);
  }
}
