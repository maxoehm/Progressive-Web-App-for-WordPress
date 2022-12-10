package de.wpwa.app.data.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostmetaRepository extends JpaRepository<Postmeta, Long> {

    Postmeta findByPostId(Long postId);

    @Query(value = "select * from _postmeta as u where u.post_id = :post_id",
            nativeQuery = true)
    List<Postmeta> findByCustomQuery(@Param("post_id") Long post_id);


}