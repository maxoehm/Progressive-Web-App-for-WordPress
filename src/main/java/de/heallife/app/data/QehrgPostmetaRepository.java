package de.heallife.app.data;

import de.heallife.app.data.entity.QehrgPostmeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QehrgPostmetaRepository extends JpaRepository<QehrgPostmeta, Long> {

    QehrgPostmeta findByPostId(Long id);


}