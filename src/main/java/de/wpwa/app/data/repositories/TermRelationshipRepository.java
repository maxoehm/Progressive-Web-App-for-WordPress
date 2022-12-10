package de.wpwa.app.data.repositories;

import de.wpwa.app.data.entity.TermRelationship;
import de.wpwa.app.data.entity.TermRelationshipId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TermRelationshipRepository
    extends JpaRepository<TermRelationship, TermRelationshipId> {

  List<TermRelationship> findTermRelationshipsByIdObjectId(Long idObject);

  List<TermRelationship> findAllById_TermTaxonomyId(Long taxId);
}
