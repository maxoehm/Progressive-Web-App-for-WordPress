package de.heallife.app.data.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QehrgUsermetaRepository extends JpaRepository<QehrgUsermeta, Long> {

    QehrgUsermeta findByUserId(Long userId);


}