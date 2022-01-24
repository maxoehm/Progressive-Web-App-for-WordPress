package de.heallife.app.security;

import de.heallife.app.data.QehrgUser;
import de.heallife.app.data.entity.QehrgMeprSubscription;
import de.heallife.app.data.entity.QehrgMeprSubscriptionRepository;
import de.heallife.app.data.service.QehrgUserRepository;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired private QehrgUserRepository userRepository;
  @Autowired private QehrgMeprSubscriptionRepository subscriptionRepository;

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

    if (subscriptionActive(user)) {
      return new org.springframework.security.core.userdetails.User(
          user.getUserLogin(),
          user.getUserPass(),
          Collections.singleton(new SimpleGrantedAuthority("ROLE_" + "USER")));
    } else {
      throw new UsernameNotFoundException("Subscription is not active");
    }
  }

  private List<QehrgMeprSubscription> member;

  private boolean subscriptionActive(QehrgUser user) {

    try {
      member = subscriptionRepository.findByUserId(Long.valueOf(user.getId()));
    } catch (IncorrectResultSizeDataAccessException e) {
      for (QehrgMeprSubscription qehrgMeprSubscription : member) {

        // ToDo: Replace active call with subsription mangement bean

        if (qehrgMeprSubscription.getStatus().equals("active")) {
          return true;
        }
      }
    }

    return member.get(0).getStatus().equals("active");
  }
}
