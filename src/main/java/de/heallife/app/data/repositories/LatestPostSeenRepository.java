package de.heallife.app.data.repositories;

import de.heallife.app.data.entity.LatestPosts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LatestPostSeenRepository extends CrudRepository<LatestPosts, Long> {

    @Query("select l from latest_posts_seen l where upper(l.username) = upper(?1)")
    Optional<LatestPosts> findByUsernameIgnoreCase(@NonNull String username);


}
