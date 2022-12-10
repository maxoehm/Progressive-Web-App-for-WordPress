package de.wpwa.app.data.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeprSubscriptionRepository extends JpaRepository<MeprSubscription, Integer> {


    List<MeprSubscription> findByUserId(Long id);

}