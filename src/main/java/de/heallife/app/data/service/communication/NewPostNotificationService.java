package de.heallife.app.data.service.communication;

import de.heallife.app.data.QehrgUser;
import de.heallife.app.data.entity.Post;
import de.heallife.app.data.entity.PostMetaService;
import de.heallife.app.data.service.CategoryService;
import de.heallife.app.data.service.QehrgUserService;
import de.heallife.app.security.PostService;
import java.util.Optional;
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

  private Optional<Post> returnValue;

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
    try {

      if (!user.getPostPopUpLastSeen().equals(post.get().getId())) {
        returnValue = post;

        if (latestUpdatedPost.isPresent()) {
          if (!user.getPostPopUpLastSeen().equals(latestUpdatedPost.get().getId())) {
            returnValue = latestUpdatedPost;
          }
        }

        return true;
      }

    } catch (NullPointerException e) {
      return true;
    }

    return false;
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
    return returnValue;
  }

  public String getImageUrl() {
    return postMetaService.findFeaturedImage(post.get().getId());
  }

  public void setSeen() {
    user.setPostPopUpLastSeen(post.get().getId());
    userService.updateEntity(user);
  }
}
