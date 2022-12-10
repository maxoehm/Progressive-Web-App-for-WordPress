package de.wpwa.app.data.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "latest_posts_seen")
public class LatestPosts {

  @Id @NotNull private String username;

  private Integer val1;
  private Integer val2;

  public LatestPosts() {}

  public LatestPosts(String username) {
    this.username = username;
    this.val1 = 0;
    this.val2 = 0;
  }

  public void setNewPostId(Integer id) {
    if (val1 == 0) {
      val1 = id;
      val2 = id;
    } else {
      val2 = id;
      val1 = val2;
    }
  }

  public Integer getVal1() {
    return val1;
  }

  public void setVal1(Integer postIDOne) {
    this.val1 = postIDOne;
  }

  public Integer getVal2() {
    return val2;
  }

  public void setVal2(Integer postIDTwo) {
    this.val2 = postIDTwo;
  }

  public boolean isNull() {
    return val1 == null && val2 == null;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
