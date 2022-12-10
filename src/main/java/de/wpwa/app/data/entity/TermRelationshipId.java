package de.wpwa.app.data.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.hibernate.Hibernate;

@Embeddable
public class TermRelationshipId implements Serializable {
  private static final long serialVersionUID = 3862252456563784994L;

  @Column(name = "object_id", nullable = false)
  private Long objectId;

  @Column(name = "term_taxonomy_id", nullable = false)
  private Long termTaxonomyId;

  public Long getTermTaxonomyId() {
    return termTaxonomyId;
  }

  public void setTermTaxonomyId(Long termTaxonomyId) {
    this.termTaxonomyId = termTaxonomyId;
  }

  public Long getObjectId() {
    return objectId;
  }

  public void setObjectId(Long objectId) {
    this.objectId = objectId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(termTaxonomyId, objectId);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    TermRelationshipId entity = (TermRelationshipId) o;
    return Objects.equals(this.termTaxonomyId, entity.termTaxonomyId)
        && Objects.equals(this.objectId, entity.objectId);
  }
}
