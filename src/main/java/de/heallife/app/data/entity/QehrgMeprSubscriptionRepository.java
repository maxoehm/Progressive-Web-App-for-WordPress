package de.heallife.app.data.entity;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QehrgMeprSubscriptionRepository
    extends JpaRepository<QehrgMeprSubscription, Integer> {

  List<QehrgMeprSubscription> findByUserId(Long id);
}
