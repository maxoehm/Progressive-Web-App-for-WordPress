package de.heallife.app.data.repositories;

import de.heallife.app.data.entity.QehrgMeprTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface QehrgMeprTransactionRepository extends JpaRepository<QehrgMeprTransaction, Integer> {

    List<QehrgMeprTransaction> findQehrgMeprTransactionByUserId(Long userId);
    List<QehrgMeprTransaction> findByUserIdAndExpiresAtIsLessThan(Long userId, Instant time);

}