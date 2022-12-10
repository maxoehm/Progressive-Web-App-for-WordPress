package de.wpwa.app.data.entity;


import javax.persistence.*;
import java.io.Serializable;

@Table(name = "_postmeta", indexes = {
        @Index(name = "post_id", columnList = "post_id"),
        @Index(name = "meta_key", columnList = "meta_key")
})
@Entity
@IdClass(PostmetaPK.class)
public class Postmeta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meta_id", nullable = false)
    private Long id1;

    @Id
    @Column(name = "post_id", nullable = false)
    private Long postId;

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

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getId1() {
        return id1;
    }

    public void setId1(Long id1) {
        this.id1 = id1;
    }
}