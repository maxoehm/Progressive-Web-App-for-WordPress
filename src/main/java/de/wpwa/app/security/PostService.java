package de.wpwa.app.security;

import de.wpwa.app.data.entity.Post;
import de.wpwa.app.data.service.PostRepository;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostService {

  private PostRepository repo;

  @Inject
  public PostService(PostRepository repo) {
    this.repo = repo;
  }

  public List<Post> getPost() {
    return repo.findAll();
  }

  public List<Post> getPost(String postType) {
    return repo.findByPostType(postType);
  }

  public List<Post> getPost(String postType, String postStatus) {
    return repo.findByPostTypeAndPostStatusAllIgnoreCase(postType, postStatus);
  }

  public Page<Post> getPostByNewest(String postType, String postStatus, Pageable paging) {
    return repo.findByPostTypeAndPostStatusAllIgnoreCaseOrderByPostDateDesc(
        postType, postStatus, paging);
  }

  public Optional<Post> getLatest() {
    return repo.findTopByPostTypeAndPostStatusOrderByPostDateDesc("post", "publish");
  }

  public Optional<List<Post>> getLatestEdits() {
    return repo.findTop5ByPostTypeAndPostStatusOrderByPostModifiedDesc("post", "publish");
  }

  public Optional<Post> getPostById(Integer id) {
    return repo.findById(id);
  }

  public Post getPostByIdAndPostStatus(Integer id, String postStatus) {
    return repo.findByIdAndPostStatusIs(id, postStatus);
  }

  public List searchByString(String s) {
    return repo
        .findByPostTypeAndPostStatusAllIgnoreCaseAndPostTitleContainingOrPostContentContaining(
            "post", "publish", s, s);
  }
}
