package de.heallife.app.data.service;

import de.heallife.app.data.entity.QehrgPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QehrgPostRepository extends JpaRepository<QehrgPost, Integer> {

    List<QehrgPost> findByPostType(String postType);

    List<QehrgPost> findAll();

    List<QehrgPost> findByPostTypeAndPostStatusAllIgnoreCase(String posttype, String status);

    List<QehrgPost> findByPostTypeAndPostStatusAllIgnoreCaseAndPostTitleContainingOrPostContentContaining(String posttype, String status, String title, String content);

    QehrgPost findByIdAndPostStatusIs(int i, String status);

}