package de.wpwa.app.data.entity;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeprSubscriptionRepository extends JpaRepository<MeprSubscription, Integer> {

  List<MeprSubscription> findByUserId(Long id);
}
