package de.wpwa.app.data.service.communication;

import de.wpwa.app.data.User;
import de.wpwa.app.data.entity.LatestPosts;
import de.wpwa.app.data.entity.Post;
import de.wpwa.app.data.entity.PostMetaService;
import de.wpwa.app.data.service.CategoryService;
import de.wpwa.app.data.service.UserService;
import de.wpwa.app.data.service.library.LatestPostSeenService;
import de.wpwa.app.security.PostService;
import java.time.LocalDateTime;
import java.util.Optional;
import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class NewPostNotificationService {

  private PostService postService;
  private PostMetaService postMetaService;
  private UserService userService;
  private CategoryService categoryService;

  private LatestPostSeenService latestPostSeenService;

  private Optional<Post> latestPost = Optional.empty();
  private User user;
  private Optional<Post> post;
  private Optional<Post> latestUpdatedPost;
  private LatestPosts latestPosts;

  @Inject
  public NewPostNotificationService(
      PostService postService,
      PostMetaService postMetaService,
      UserService userService,
      CategoryService categoryService,
      LatestPostSeenService latestPostSeenService) {
    this.postService = postService;
    this.postMetaService = postMetaService;
    this.userService = userService;
    this.categoryService = categoryService;
    this.latestPostSeenService = latestPostSeenService;
  }

  public void init(String auth) {
    user = userService.findAuth(auth);
    post = postService.getLatest();
    latestPost = postService.getLatest();
    latestUpdatedPost = get5LatestUpdates();
    latestPosts = latestPostSeenService.get(user.getUserEmail());
  }

  public boolean isNewPostAvailable() {
    int barrier = 0;

    try {
      if (user.getLastPopupSeen().isBefore(LocalDateTime.now().minusHours(24))
          && latestUpdatedPost.isPresent()) {
        barrier++;
      }

      if (!latestPosts.getVal2().equals(post.get().getId())) {
        barrier++;
      }

    } catch (NullPointerException e) {
      return true;
    }

    return barrier >= 1;
  }

  private Optional<Post> get5LatestUpdates() {
    postService.getLatestEdits();
    for (Post p : postService.getLatestEdits().get()) {
      if (categoryService.isInCategory(CategoryService.CATEGORY.Category1, p)) {
        return Optional.of(p);
      }
    }
    return Optional.empty();
  }

  public Optional<Post> getPost() {

    user.setLastPopupSeen(LocalDateTime.now());

    try {

      if (!latestPosts.getVal2().equals(post.get().getId())) {
        latestPosts.setNewPostId(post.get().getId());
        userService.updateEntity(user);
        return latestPost;
      } else

      if (LocalDateTime.now().isAfter(user.getLastPopupSeen().plusHours(12))
          && latestUpdatedPost.isPresent()) {

        if (!latestPosts.getVal1().equals(latestUpdatedPost.get().getId())) {
          latestPosts.setNewPostId(latestUpdatedPost.get().getId());
          userService.updateEntity(user);
          return latestUpdatedPost;
        }
      }

    } catch (NullPointerException e) {
      userService.updateEntity(user);
      return latestPost;
    }

    return Optional.empty();
  }

  public String getImageUrl() {
    return postMetaService.findFeaturedImage(post.get().getId());
  }

  public void close() {
    latestPosts.setUsername(user.getUserEmail());
    latestPostSeenService.save(latestPosts);
  }

}
