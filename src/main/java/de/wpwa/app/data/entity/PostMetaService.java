package de.wpwa.app.data.entity;

import de.wpwa.app.security.PostService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PostMetaService {


    private PostmetaRepository repo;
    private PostService service;
    private String metaValue;

    public PostMetaService(PostmetaRepository repo, PostService service) {
        this.repo = repo;
        this.service = service;

    }

    public Postmeta findByPostId(Long postId) {
        return repo.findByPostId(postId);
    }

    public String findFeaturedImage(Integer postId) throws NumberFormatException, NoSuchElementException {
        var entity = repo.findByCustomQuery(Long.valueOf(postId));

        for (int i = 0; i < entity.size(); i++) {
                if (entity.get(i).getMetaKey().equals("_thumbnail_id")) {
                    metaValue = entity.get(i).getMetaValue();
                    break;
                }
        }

        var object = service.getPostById(Integer.valueOf(metaValue));

        try {
            return object.get().getGuid();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("No featured image found");
        }
    }
}
