package de.heallife.app.data.service;

import de.heallife.app.data.QehrgUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

@Repository
@Table(name = "QEhRG_users")
public interface QehrgUserRepository extends JpaRepository<QehrgUser, Integer> {


    @Query(value = "select * from QEhRG_users as u where u.user_nicename = :name",
            nativeQuery = true)
    QehrgUser findByCustomQuery(@Param("name") String name);

}