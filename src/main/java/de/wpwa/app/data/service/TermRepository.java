package de.wpwa.app.data.service;

import de.wpwa.app.data.entity.TermEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TermRepository extends JpaRepository<TermEntity, Long> {

    List<TermEntity> findById1(Long categoryId);


}