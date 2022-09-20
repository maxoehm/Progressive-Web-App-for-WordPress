package de.heallife.app.data.service.communication;

import de.heallife.app.data.AbstractEntity;
import de.heallife.app.data.QehrgUser;
import de.heallife.app.data.entity.PostMetaService;
import de.heallife.app.data.entity.QehrgPost;
import de.heallife.app.data.service.CategoryService;
import de.heallife.app.data.service.QehrgUserService;
import de.heallife.app.security.PostService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.persistence.PostLoad;
import java.util.List;
import java.util.Optional;

@Service
public class NewPostNotificationService {

    private PostService postService;
    private PostMetaService postMetaService;
    private QehrgUserService userService;
    private CategoryService categoryService;

    private Optional<QehrgPost> latestPost = Optional.empty();
    private QehrgUser user;
    private Optional<QehrgPost> post;
    private Optional<QehrgPost> latestUpdatedPost;

    private Optional<QehrgPost> returnValue;

    @Inject
    public NewPostNotificationService(PostService postService, PostMetaService postMetaService, QehrgUserService userService, CategoryService categoryService) {
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

        } catch (NullPointerException e){
            return true;
        }

        return false;
    }

    private Optional<QehrgPost> get5LatestUpdates() {
        postService.getLatestEdits();
        for (QehrgPost p : postService.getLatestEdits().get()) {
            if (categoryService.isInCategory(CategoryService.CATEGORY.Challenges, p)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public Optional<QehrgPost> getPost() {
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
