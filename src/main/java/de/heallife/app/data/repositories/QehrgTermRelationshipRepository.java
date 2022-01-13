package de.heallife.app.data.repositories;

import de.heallife.app.data.entity.QehrgTermRelationship;
import de.heallife.app.data.entity.QehrgTermRelationshipId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QehrgTermRelationshipRepository extends JpaRepository<QehrgTermRelationship, QehrgTermRelationshipId> {

    List<QehrgTermRelationship> findQehrgTermRelationshipsByIdObjectId(Long idObject);
    List<QehrgTermRelationship> findAllById_TermTaxonomyId(Long taxId);

}