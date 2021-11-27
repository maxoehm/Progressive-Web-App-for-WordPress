package de.heallife.app.data.entity;

import de.heallife.app.data.QehrgUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QehrgPostmetaRepository extends JpaRepository<QehrgPostmeta, Long> {

    QehrgPostmeta findByPostId(Long postId);

    @Query(value = "select * from qehrg_postmeta as u where u.post_id = :post_id",
            nativeQuery = true)
    List<QehrgPostmeta> findByCustomQuery(@Param("post_id") Long post_id);


}