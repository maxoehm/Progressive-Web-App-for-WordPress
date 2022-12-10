package de.wpwa.app.data.service;

import de.wpwa.app.data.entity.TermEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TermRepository extends JpaRepository<TermEntity, Long> {

  List<TermEntity> findById1(Long categoryId);
}
