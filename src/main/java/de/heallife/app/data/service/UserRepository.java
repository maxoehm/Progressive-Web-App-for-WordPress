package de.heallife.app.data.service;

import de.heallife.app.data.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import de.heallife.app.data.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.Lob;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}