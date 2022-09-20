package de.heallife.app.data.service;

import de.heallife.app.data.entity.QehrgPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface QehrgPostRepository extends JpaRepository<QehrgPost, Integer> {

    List<QehrgPost> findByPostType(String postType);

    List<QehrgPost> findAll();

    List<QehrgPost> findByPostTypeAndPostStatusAllIgnoreCase(String posttype, String status);

    Optional<QehrgPost> findTopByPostTypeAndPostStatusOrderByPostDateDesc(String postType, String postStatus);

    Optional<List<QehrgPost>> findTop5ByPostTypeAndPostStatusOrderByPostModifiedDesc(String postType, String postStatus);

    Optional<QehrgPost> findTopByPostTypeAndPostStatusOrderByPostDate(String postType, String postStatus);

    List<QehrgPost> findByPostTypeAndPostStatusAllIgnoreCaseAndPostTitleContainingOrPostContentContaining(String posttype, String status, String title, String content);

    QehrgPost findByIdAndPostStatusIs(int i, String status);

}