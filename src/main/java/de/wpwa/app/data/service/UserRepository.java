package de.wpwa.app.data.service;

import de.wpwa.app.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name = "_users")
public interface UserRepository extends JpaRepository<User, Integer> {


    @Query(value = "select * from _users as u where u.user_nicename = :name",
            nativeQuery = true)
    User findByCustomQuery(@Param("name") String name);

    @Query(value = "select * from _users as u where u.user_email = :email",
            nativeQuery = true)
    User findByCustomQueryEmail(@Param("email") String email);

    User findUserByUserEmail(String email);
    User findUserByUserNicename(String name);
}