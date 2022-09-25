package de.heallife.app.security;

import de.heallife.app.data.entity.Post;
import de.heallife.app.data.service.QehrgPostRepository;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostService {

  private QehrgPostRepository repo;

  @Inject
  public PostService(QehrgPostRepository repo) {
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
