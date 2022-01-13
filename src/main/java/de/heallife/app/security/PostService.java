package de.heallife.app.security;

import de.heallife.app.data.entity.QehrgPost;
import de.heallife.app.data.service.CategoryService;
import de.heallife.app.data.service.QehrgPostRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PostService {

    private QehrgPostRepository repo;

    @Inject
    public PostService(QehrgPostRepository repo) {
        this.repo = repo;
    }

    public List<QehrgPost> getPost() {
        return repo.findAll();
    }

    public List<QehrgPost> getPost(String postType) {
        return repo.findByPostType(postType);
    }

    public List<QehrgPost> getPost(String postType, String postStatus) {
        return repo.findByPostTypeAndPostStatusAllIgnoreCase(postType, postStatus);
    }

    public Optional<QehrgPost> getPostById(Integer id) {
        return repo.findById(id);
    }

    public QehrgPost getPostByIdAndPostStatus(Integer id, String postStatus) {
        return repo.findByIdAndPostStatusIs(id, postStatus);
    }


    public List searchByString(String s) {
        return repo.findByPostTypeAndPostStatusAllIgnoreCaseAndPostTitleContainingOrPostContentContaining("post", "publish", s, s);
    }
}
