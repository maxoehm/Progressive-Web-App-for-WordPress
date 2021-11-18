package de.heallife.app.security;

import de.heallife.app.data.QehrgPostmetaRepository;
import de.heallife.app.data.entity.QehrgPost;
import de.heallife.app.data.service.QehrgPostRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private QehrgPostRepository repo;
    private QehrgPostmetaRepository metaRepo;

    @Inject
    public PostService(QehrgPostRepository repo, QehrgPostmetaRepository metaRepo) {
        this.repo = repo;
        this.metaRepo = metaRepo;
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


}
