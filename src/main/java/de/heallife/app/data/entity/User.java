package de.heallife.app.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.heallife.app.data.AbstractEntity;
import de.heallife.app.data.Role;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;

@Entity
public class User extends AbstractEntity {

  private String username;
  private String name;
  @JsonIgnore private String hashedPassword;

  @ElementCollection(fetch = FetchType.EAGER)
  private Set<Role> roles;

  @Lob private String profilePictureUrl;
  private long hasViewNotify;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getHashedPassword() {
    return hashedPassword;
  }

  public void setHashedPassword(String hashedPassword) {
    this.hashedPassword = hashedPassword;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public String getProfilePictureUrl() {
    return profilePictureUrl;
  }

  public void setProfilePictureUrl(String profilePictureUrl) {
    this.profilePictureUrl = profilePictureUrl;
  }

  public long getHasViewNotify() {
    return hasViewNotify;
  }

  public void setHasViewNotify(long hasViewNotify) {
    this.hasViewNotify = hasViewNotify;
  }
}
