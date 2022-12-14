package de.wpwa.app.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.time.Instant;
import java.time.LocalDateTime;

@Table(
    name = "_users",
    indexes = {
      @Index(name = "user_email", columnList = "user_email"),
      @Index(name = "user_login_key", columnList = "user_login"),
      @Index(name = "user_nicename", columnList = "user_nicename")
    })
@Entity
public class User extends AbstractEntity {

  @Column(name = "user_login", nullable = false, length = 60)
  private String userLogin;

  @Column(name = "user_pass", nullable = false)
  private String userPass;

  @Column(name = "user_nicename", nullable = false, length = 50)
  private String userNicename;

  @Column(name = "user_email", nullable = false, length = 100)
  private String userEmail;

  @Column(name = "user_url", nullable = false, length = 100)
  private String userUrl;

  @Column(name = "user_registered", nullable = false)
  private Instant userRegistered;

  @Column(name = "user_status", nullable = false)
  private Integer userStatus;

  @Column(name = "display_name", nullable = false, length = 250)
  private String displayName;

  @Column(name = "user_activation_key", nullable = false)
  private String userActivationKey;

  private LocalDateTime lastPopupSeen;

  public String getUserActivationKey() {
    return userActivationKey;
  }

  public void setUserActivationKey(String userActivationKey) {
    this.userActivationKey = userActivationKey;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public Integer getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(Integer userStatus) {
    this.userStatus = userStatus;
  }

  public Instant getUserRegistered() {
    return userRegistered;
  }

  public void setUserRegistered(Instant userRegistered) {
    this.userRegistered = userRegistered;
  }

  public String getUserUrl() {
    return userUrl;
  }

  public void setUserUrl(String userUrl) {
    this.userUrl = userUrl;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public String getUserNicename() {
    return userNicename;
  }

  public void setUserNicename(String userNicename) {
    this.userNicename = userNicename;
  }

  public String getUserPass() {
    return userPass;
  }

  public void setUserPass(String userPass) {
    this.userPass = userPass;
  }

  public String getUserLogin() {
    return userLogin;
  }

  public void setUserLogin(String userLogin) {
    this.userLogin = userLogin;
  }

  public LocalDateTime getLastPopupSeen() {
    if (lastPopupSeen == null) {
      return LocalDateTime.of(2000, 1, 1, 0, 0);
    }
    return lastPopupSeen;
  }

  public void setLastPopupSeen(LocalDateTime lastPopupSeen) {
    this.lastPopupSeen = lastPopupSeen;
  }
}
