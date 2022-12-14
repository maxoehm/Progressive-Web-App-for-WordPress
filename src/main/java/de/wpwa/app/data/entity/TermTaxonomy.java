package de.wpwa.app.data.entity;

import de.wpwa.app.data.AbstractEntity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "_term_taxonomy", indexes = {
        @Index(name = "term_id_taxonomy", columnList = "term_id, taxonomy", unique = true),
        @Index(name = "taxonomy", columnList = "taxonomy")
})
@IdClass(TermTaxonomy.TermTaxonomyId.class)
@Entity
public class TermTaxonomy extends AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "term_taxonomy_id", nullable = false)
    private Long id1;

    @Column(name = "term_id", nullable = false)
    private Long termId;

    @Column(name = "taxonomy", nullable = false, length = 32)
    private String taxonomy;

    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "parent", nullable = false)
    private Long parent;

    @Column(name = "count", nullable = false)
    private Long count;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(String taxonomy) {
        this.taxonomy = taxonomy;
    }

    public Long getTermId() {
        return termId;
    }

    public void setTermId(Long termId) {
        this.termId = termId;
    }

    public Long getId1() {
        return id1;
    }

    public void setId1(Long id1) {
        this.id1 = id1;
    }

    public class TermTaxonomyId implements Serializable {

        private Long id;
        private Long id1;

    }
}