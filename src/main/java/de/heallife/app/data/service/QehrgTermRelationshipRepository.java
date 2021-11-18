package de.heallife.app.data.service;

import de.heallife.app.data.entity.QehrgTermRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QehrgTermRelationshipRepository extends JpaRepository<QehrgTermRelationship, Long> {


    List<QehrgTermRelationship> findById1(Long id1);

}