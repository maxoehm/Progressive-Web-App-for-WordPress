package de.wpwa.app.data.repositories;

import de.wpwa.app.data.entity.MeprTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface MeprTransactionRepository extends JpaRepository<MeprTransaction, Integer> {

    List<MeprTransaction> findMeprTransactionByUserId(Long userId);
    List<MeprTransaction> findByUserIdAndExpiresAtIsLessThan(Long userId, Instant time);

}