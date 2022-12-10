package de.wpwa.app.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "_term_relationships", indexes = {
        @Index(name = "object_id", columnList = "object_id"),
})
public class TermRelationship {

    @EmbeddedId
    private TermRelationshipId id;

    @Column(name = "term_order", nullable = false)
    private Integer termOrder;

    public Integer getTermOrder() {
        return termOrder;
    }

    public void setTermOrder(Integer termOrder) {
        this.termOrder = termOrder;
    }

    public TermRelationshipId getId() {
        return id;
    }

    public void setId(TermRelationshipId id) {
        this.id = id;
    }
}