package de.heallife.app.data.service;

import de.heallife.app.data.entity.QehrgTermEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QehrgTermRepository extends JpaRepository<QehrgTermEntity, Long> {

  List<QehrgTermEntity> findById1(Long categoryId);
}
