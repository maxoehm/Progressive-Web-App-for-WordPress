package de.heallife.app.data.service;

import de.heallife.app.data.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QehrgPostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByPostType(String postType);

    List<Post> findAll();

    List<Post> findByPostTypeAndPostStatusAllIgnoreCase(String posttype, String status);

    Optional<Post> findTopByPostTypeAndPostStatusOrderByPostDateDesc(String postType, String postStatus);

    Optional<List<Post>> findTop5ByPostTypeAndPostStatusOrderByPostModifiedDesc(String postType, String postStatus);

    Optional<Post> findTopByPostTypeAndPostStatusOrderByPostDate(String postType, String postStatus);

    List<Post> findByPostTypeAndPostStatusAllIgnoreCaseAndPostTitleContainingOrPostContentContaining(String posttype, String status, String title, String content);

    Post findByIdAndPostStatusIs(int i, String status);

    Page<Post> findByPostTypeAndPostStatusAllIgnoreCaseOrderByPostDateDesc(String postType, String postStatus, Pageable pageable);

}