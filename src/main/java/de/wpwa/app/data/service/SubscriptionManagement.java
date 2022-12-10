package de.wpwa.app.data.service;

import de.wpwa.app.data.User;
import de.wpwa.app.data.entity.MeprSubscription;
import de.wpwa.app.data.entity.MeprSubscriptionRepository;
import de.wpwa.app.data.entity.MeprTransaction;
import de.wpwa.app.data.repositories.MeprTransactionRepository;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionManagement {

  private MeprTransactionRepository meprTransactionRepository;
  private MeprSubscriptionRepository subscriptionRepository;

  @Inject
  public SubscriptionManagement(
      MeprTransactionRepository meprTransactionRepository,
      MeprSubscriptionRepository subscriptionRepository) {
    this.meprTransactionRepository = meprTransactionRepository;
    this.subscriptionRepository = subscriptionRepository;
  }

  public boolean isSubscriptionActive(User user) {

    List<MeprTransaction> transaction =
        meprTransactionRepository.findMeprTransactionByUserId(getUser(user).getUserId());

    for (MeprTransaction t1 : transaction) {
      Date exp = Date.from(t1.getExpiresAt());
      Date now = Date.from(Instant.now());

      Calendar cal = Calendar.getInstance();
      cal.setTime(exp);
      cal.add(Calendar.DAY_OF_MONTH, 3);

      if (cal.getTime().after(now)) {
        return true;
      }
    }
    return false;
  }

  private MeprSubscription getUser(User user) {
    var b = subscriptionRepository.findByUserId(Long.valueOf(user.getId()));
    return b.get(0);
  }

  /**
   * Access MemberPress Subscriptions and look for sub for current user, and return true if sub is
   * not expired.
   */
}
