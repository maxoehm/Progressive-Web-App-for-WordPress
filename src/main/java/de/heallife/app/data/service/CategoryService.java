package de.heallife.app.data.service;

import de.heallife.app.data.entity.QehrgPost;
import de.heallife.app.security.PostService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class CategoryService {

    private PostService postService;
    private QehrgTermRepository termRepository;

    @Inject
    public CategoryService(PostService postService, QehrgTermRepository termRepository) {
        this.postService  = postService;
        this.termRepository = termRepository;


    }

    @PersistenceContext
    private EntityManager em;

    public List<String> getCategories(QehrgPost post) {

        String query = "select * from QEhRG_term_relationships as u where u.object_id = :vx";
        Query q = em.createNativeQuery(query);
        q.setParameter("vx", post.getId());
        List<Object[]> resultList = q.getResultList();

        List<String> categories = new ArrayList<>();

        for (Object[] objects : resultList) {

            var entity = Integer.parseInt(objects[1].toString());

            if (entity == 18) {
                categories.add("Mediathek");
            } else

            if (entity == 94) {
                categories.add("Gezielte Bewegung");
            } else

            if (entity == 22) {
                categories.add("Lifestyle");
            } else

            if (entity == 23) {
                categories.add("Yoga");
            } else

            if (entity == 25) {
                categories.add("Freizeit");
            } else

            if (entity == 26) {
                categories.add("Ernährung");
            } else

            if (entity == 27) {
                categories.add("Meditation");
            } else

            if (entity == 28) {
                categories.add("Allgemeinwissen");
            } else

            if (entity == 29) {
                categories.add("Empfehlungen");
            } else

            if (entity == 30) {
                categories.add("Artikel");
            } else

            if (entity == 31) {
                categories.add("Podcast");
            } else

            if (entity == 32) {
                categories.add("Video");
            } else

            if (entity == 95) {
                categories.add("Events");
            } else

            if (entity == 96) {
                categories.add("Events Online");
            } else

            if (entity == 49) {
                categories.add("Seelische und mentale Gesundheit");
            } else

            if (entity == 93) {
                categories.add("Ja' hör mal Gabi!");
            }

            if (entity == 97) {
                categories.add("Physische Gesundheit");
            }

        }

        return categories;
    }

    @Transactional
    public List<QehrgPost> getPostByCategory(String postType, String postStatus, String category) {
        List<QehrgPost> posts = postService.getPost(postType, postStatus);

        List<QehrgPost> filteredPosts = new ArrayList<>();

        for (int i = 0; i < posts.size(); i++) {

            for (int j = 0; j < getCategories(posts.get(i)).size(); j++) {

                if (Objects.equals(getCategories(posts.get(i)).get(j), category)) {
                    filteredPosts.add(posts.get(i));
                }
            }
        }

        return filteredPosts;
    }


    public List<QehrgPost> getAllPosts() {
        return postService.getPost("post", "publish");
    }

}
