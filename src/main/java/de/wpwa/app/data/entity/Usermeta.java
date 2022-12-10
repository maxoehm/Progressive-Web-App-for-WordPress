package de.wpwa.app.data.entity;

import javax.persistence.*;

@Table(name = "_usermeta", indexes = {
        @Index(name = "user_id", columnList = "user_id"),
        @Index(name = "meta_key", columnList = "meta_key")
})
@Entity
public class Usermeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "umeta_id", nullable = false)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "meta_key")
    private String metaKey;

    @Lob
    @Column(name = "meta_value")
    private String metaValue;

    public String getMetaValue() {
        return metaValue;
    }

    public void setMetaValue(String metaValue) {
        this.metaValue = metaValue;
    }

    public String getMetaKey() {
        return metaKey;
    }

    public void setMetaKey(String metaKey) {
        this.metaKey = metaKey;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}