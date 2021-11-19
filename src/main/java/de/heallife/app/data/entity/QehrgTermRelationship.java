package de.heallife.app.data.entity;

import de.heallife.app.data.AbstractEntity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "qehrg_term_relationships")
@Entity
@IdClass(QehrgTermRelationshipId.class)
public class QehrgTermRelationship extends AbstractEntity implements Serializable {

    @Id
    @Column(name = "object_id", nullable = false)
    private Long id1;

    @Id
    @Column(name = "term_taxonomy_id", nullable = false)
    private Long id2;

    @Column(name = "term_order", nullable = false)
    private Integer termOrder;

    public Integer getTermOrder() {
        return termOrder;
    }

    public void setTermOrder(Integer termOrder) {
        this.termOrder = termOrder;
    }

    public Long getId2() {
        return id2;
    }

    public void setId2(Long id2) {
        this.id2 = id2;
    }

    public Long getId1() {
        return id1;
    }

    public void setId1(Long id1) {
        this.id1 = id1;
    }
}