package de.heallife.app.data.service;

import de.heallife.app.data.entity.QehrgTermEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QehrgTermRepository extends JpaRepository<QehrgTermEntity, Long> {

    List<QehrgTermEntity> findById1(Long categoryId);


}