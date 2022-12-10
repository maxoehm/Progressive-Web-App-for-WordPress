package de.wpwa.app.data.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsermetaRepository extends JpaRepository<Usermeta, Long> {

    Usermeta findByUserId(Long userId);

    Usermeta findByUserIdAndMetaKey(Long userId, String metaKey);


}