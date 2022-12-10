package de.heallife.app.data.repositories;

import de.heallife.app.data.entity.QehrgMeprTransaction;
import java.time.Instant;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QehrgMeprTransactionRepository
    extends JpaRepository<QehrgMeprTransaction, Integer> {

  List<QehrgMeprTransaction> findQehrgMeprTransactionByUserId(Long userId);

  List<QehrgMeprTransaction> findByUserIdAndExpiresAtIsLessThan(Long userId, Instant time);
}
