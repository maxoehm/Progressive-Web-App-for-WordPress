package de.heallife.app.data.entity;

import de.heallife.app.data.AbstractEntity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "QEhRG_terms", indexes = {
        @Index(name = "name", columnList = "name"),
        @Index(name = "slug", columnList = "slug")
})
@Entity
public class QehrgTermEntity extends AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "term_id", nullable = false)
    private Long id1;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "slug", nullable = false, length = 200)
    private String slug;

    @Column(name = "term_group", nullable = false)
    private Long termGroup;

    public Long getTermGroup() {
        return termGroup;
    }

    public void setTermGroup(Long termGroup) {
        this.termGroup = termGroup;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId1() {
        return id1;
    }

    public void setId1(Long id1) {
        this.id1 = id1;
    }
}