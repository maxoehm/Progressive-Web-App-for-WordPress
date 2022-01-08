package de.heallife.app.data.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QehrgMeprSubscriptionRepository extends JpaRepository<QehrgMeprSubscription, Integer> {


    List<QehrgMeprSubscription> findByUserId(Long id);

}