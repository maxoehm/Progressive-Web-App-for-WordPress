package de.heallife.app.data.entity;

import de.heallife.app.security.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostMetaService {


    private QehrgPostmetaRepository repo;
    private PostService service;
    private String metaValue;

    public PostMetaService(QehrgPostmetaRepository repo, PostService service) {
        this.repo = repo;
        this.service = service;

    }

    public QehrgPostmeta findByPostId(Long postId) {
        return repo.findByPostId(postId);
    }

    public String findFeaturedImage(Integer postId) {
        var entity = repo.findByCustomQuery(Long.valueOf(postId));


        for (int i = 0; i < entity.size(); i++) {
                if (entity.get(i).getMetaKey().equals("_thumbnail_id")) {
                    metaValue = entity.get(i).getMetaValue();
                    break;
                }
        }

        var object = service.getPostById(Integer.valueOf(metaValue));
        return object.get().getGuid();
    }
}