package de.heallife.app.data.entity;

import de.heallife.app.data.AbstractEntity;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import javax.persistence.*;

@Table(
    name = "QEhRG_posts",
    indexes = {
      @Index(name = "post_author", columnList = "post_author"),
      @Index(name = "post_name", columnList = "post_name"),
      @Index(name = "type_status_date", columnList = "post_type, post_status, post_date, ID"),
      @Index(name = "post_parent", columnList = "post_parent")
    })
@Entity
public class Post extends AbstractEntity implements Serializable, Comparable<Post> {
  @Column(name = "post_author", nullable = false)
  private Long postAuthor;

  @Column(name = "post_date", nullable = false)
  private Instant postDate;

  @Column(name = "post_date_gmt", nullable = false)
  private Instant postDateGmt;

  @Lob
  @Column(name = "post_content", nullable = false)
  private String postContent;

  @Lob
  @Column(name = "post_title", nullable = false)
  private String postTitle;

  @Lob
  @Column(name = "post_excerpt", nullable = false)
  private String postExcerpt;

  @Column(name = "post_status", nullable = false, length = 20)
  private String postStatus;

  @Column(name = "comment_status", nullable = false, length = 20)
  private String commentStatus;

  @Column(name = "ping_status", nullable = false, length = 20)
  private String pingStatus;

  @Column(name = "post_password", nullable = false)
  private String postPassword;

  @Column(name = "post_name", nullable = false, length = 200)
  private String postName;

  @Lob
  @Column(name = "to_ping", nullable = false)
  private String toPing;

  @Lob
  @Column(name = "pinged", nullable = false)
  private String pinged;

  @Column(name = "post_modified", nullable = false)
  private Instant postModified;

  @Column(name = "post_modified_gmt", nullable = false)
  private Instant postModifiedGmt;

  @Lob
  @Column(name = "post_content_filtered", nullable = false)
  private String postContentFiltered;

  @Column(name = "post_parent", nullable = false)
  private Long postParent;

  @Column(name = "guid", nullable = false)
  private String guid;

  @Column(name = "menu_order", nullable = false)
  private Integer menuOrder;

  @Column(name = "post_type", nullable = false, length = 20)
  private String postType;

  @Column(name = "post_mime_type", nullable = false, length = 100)
  private String postMimeType;

  @Column(name = "comment_count", nullable = false)
  private Long commentCount;

  @ElementCollection
  @Column(name = "post_category", nullable = false)
  private List<String> categories;

  public Long getCommentCount() {
    return commentCount;
  }

  public void setCommentCount(Long commentCount) {
    this.commentCount = commentCount;
  }

  public String getPostMimeType() {
    return postMimeType;
  }

  public void setPostMimeType(String postMimeType) {
    this.postMimeType = postMimeType;
  }

  public String getPostType() {
    return postType;
  }

  public void setPostType(String postType) {
    this.postType = postType;
  }

  public Integer getMenuOrder() {
    return menuOrder;
  }

  public void setMenuOrder(Integer menuOrder) {
    this.menuOrder = menuOrder;
  }

  public String getGuid() {
    return guid;
  }

  public void setGuid(String guid) {
    this.guid = guid;
  }

  public Long getPostParent() {
    return postParent;
  }

  public void setPostParent(Long postParent) {
    this.postParent = postParent;
  }

  public String getPostContentFiltered() {
    return postContentFiltered;
  }

  public void setPostContentFiltered(String postContentFiltered) {
    this.postContentFiltered = postContentFiltered;
  }

  public Instant getPostModifiedGmt() {
    return postModifiedGmt;
  }

  public void setPostModifiedGmt(Instant postModifiedGmt) {
    this.postModifiedGmt = postModifiedGmt;
  }

  public Instant getPostModified() {
    return postModified;
  }

  public void setPostModified(Instant postModified) {
    this.postModified = postModified;
  }

  public String getPinged() {
    return pinged;
  }

  public void setPinged(String pinged) {
    this.pinged = pinged;
  }

  public String getToPing() {
    return toPing;
  }

  public void setToPing(String toPing) {
    this.toPing = toPing;
  }

  public String getPostName() {
    return postName;
  }

  public void setPostName(String postName) {
    this.postName = postName;
  }

  public String getPostPassword() {
    return postPassword;
  }

  public void setPostPassword(String postPassword) {
    this.postPassword = postPassword;
  }

  public String getPingStatus() {
    return pingStatus;
  }

  public void setPingStatus(String pingStatus) {
    this.pingStatus = pingStatus;
  }

  public String getCommentStatus() {
    return commentStatus;
  }

  public void setCommentStatus(String commentStatus) {
    this.commentStatus = commentStatus;
  }

  public String getPostStatus() {
    return postStatus;
  }

  public void setPostStatus(String postStatus) {
    this.postStatus = postStatus;
  }

  public String getPostExcerpt() {
    return postExcerpt;
  }

  public void setPostExcerpt(String postExcerpt) {
    this.postExcerpt = postExcerpt;
  }

  public String getPostTitle() {
    return postTitle;
  }

  public void setPostTitle(String postTitle) {
    this.postTitle = postTitle;
  }

  public String getPostContent() {
    return postContent;
  }

  public void setPostContent(String postContent) {
    this.postContent = postContent;
  }

  public Instant getPostDateGmt() {
    return postDateGmt;
  }

  public void setPostDateGmt(Instant postDateGmt) {
    this.postDateGmt = postDateGmt;
  }

  public Instant getPostDate() {
    return postDate;
  }

  public void setPostDate(Instant postDate) {
    this.postDate = postDate;
  }

  public Long getPostAuthor() {
    return postAuthor;
  }

  public void setPostAuthor(Long postAuthor) {
    this.postAuthor = postAuthor;
  }

  public List<String> getCategories() {
    return categories;
  }

  public void setCategories(List<String> categories) {
    this.categories = categories;
  }

  @Override
  public int compareTo(Post o) {
    return this.getId().compareTo(o.getId());
  }
}
