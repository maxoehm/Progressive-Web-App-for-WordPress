package de.heallife.app.data.service.communication;

import de.heallife.app.data.QehrgUser;
import de.heallife.app.data.entity.Post;
import de.heallife.app.data.entity.PostMetaService;
import de.heallife.app.data.service.CategoryService;
import de.heallife.app.data.service.QehrgUserService;
import de.heallife.app.security.PostService;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class NewPostNotificationService {

  private PostService postService;
  private PostMetaService postMetaService;
  private QehrgUserService userService;
  private CategoryService categoryService;

  private Optional<Post> latestPost = Optional.empty();
  private QehrgUser user;
  private Optional<Post> post;
  private Optional<Post> latestUpdatedPost;

  @Inject
  public NewPostNotificationService(
      PostService postService,
      PostMetaService postMetaService,
      QehrgUserService userService,
      CategoryService categoryService) {
    this.postService = postService;
    this.postMetaService = postMetaService;
    this.userService = userService;
    this.categoryService = categoryService;
  }

  public void init(String auth) {
    user = userService.findAuth(auth);
    post = postService.getLatest();
    latestUpdatedPost = get5LatestUpdates();
  }

  public boolean isNewPostAvailable() {
    int barrier = 0;

    try {
      if (user.getLastPopupSeen().isAfter(LocalDateTime.now().minusHours(24)) && latestUpdatedPost.isPresent()) {
          barrier++;
      }

      if (!user.getPostPopUpLastSeen().equals(post.get().getId())) {
        barrier++;
      }

    } catch (NullPointerException e) {
      return true;
    }


    return barrier > 1;
  }

  private Optional<Post> get5LatestUpdates() {
    postService.getLatestEdits();
    for (Post p : postService.getLatestEdits().get()) {
      if (categoryService.isInCategory(CategoryService.CATEGORY.Challenges, p)) {
        return Optional.of(p);
      }
    }
    return Optional.empty();
  }

  public Optional<Post> getPost() {
    setSeen();

    try {

      if (LocalDateTime.now().isAfter(user.getLastPopupSeen().plusHours(24)) && latestUpdatedPost.isPresent()) {
        return latestUpdatedPost;
      }

      if (!user.getPostPopUpLastSeen().equals(post.get().getId())) {
        return latestPost;
      }
    } catch (NullPointerException e) {
      return latestPost;
    }

    return Optional.empty();
  }

  public String getImageUrl() {
    return postMetaService.findFeaturedImage(post.get().getId());
  }

  public void setSeen() {
    if (latestUpdatedPost.isEmpty()) {
      user.setPostPopUpLastSeen(post.get().getId());
      user.setLastPopupSeen(LocalDateTime.now());
      userService.updateEntity(user);
    }

  }
}
