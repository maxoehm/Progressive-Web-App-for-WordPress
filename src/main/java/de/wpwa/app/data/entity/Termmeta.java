package de.wpwa.app.data.entity;

import de.wpwa.app.data.AbstractEntity;
import java.io.Serializable;
import javax.persistence.*;

@Table(
    name = "_termmeta",
    indexes = {
      @Index(name = "term_id", columnList = "term_id"),
      @Index(name = "meta_key", columnList = "meta_key")
    })
@IdClass(Termmeta.TermmetaPK.class)
@Entity
public class Termmeta extends AbstractEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "meta_id", nullable = false)
  private Long id1;

  @Column(name = "term_id", nullable = false)
  private Long termId;

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

  public class TermmetaPK implements Serializable {

    private Long id;
    private Long id1;
  }
}
