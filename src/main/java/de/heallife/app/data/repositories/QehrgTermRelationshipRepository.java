package de.heallife.app.data.repositories;

import de.heallife.app.data.entity.QehrgTermRelationship;
import de.heallife.app.data.entity.QehrgTermRelationshipId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QehrgTermRelationshipRepository
    extends JpaRepository<QehrgTermRelationship, QehrgTermRelationshipId> {

  List<QehrgTermRelationship> findQehrgTermRelationshipsByIdObjectId(Long idObject);

  List<QehrgTermRelationship> findAllById_TermTaxonomyId(Long taxId);
}
