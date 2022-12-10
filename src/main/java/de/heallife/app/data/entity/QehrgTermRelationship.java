package de.heallife.app.data.entity;

import javax.persistence.*;

@Entity
@Table(
    name = "QEhRG_term_relationships",
    indexes = {
      @Index(name = "object_id", columnList = "object_id"),
    })
public class QehrgTermRelationship {

  @EmbeddedId private QehrgTermRelationshipId id;

  @Column(name = "term_order", nullable = false)
  private Integer termOrder;

  public Integer getTermOrder() {
    return termOrder;
  }

  public void setTermOrder(Integer termOrder) {
    this.termOrder = termOrder;
  }

  public QehrgTermRelationshipId getId() {
    return id;
  }

  public void setId(QehrgTermRelationshipId id) {
    this.id = id;
  }
}
