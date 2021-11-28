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
            }

            if (entity == 21) {
                categories.add("Kraft");
            }

            if (entity == 22) {
                categories.add("Lifestyle");
            }

            if (entity == 23) {
                categories.add("Yoga");
            }

            if (entity == 25) {
                categories.add("Freizeit");
            }

            if (entity == 26) {
                categories.add("Ernährung");
            }

            if (entity == 27) {
                categories.add("Meditation");
            }

            if (entity == 28) {
                categories.add("Allgemeinwissen");
            }

            if (entity == 29) {
                categories.add("Empfehlungen");
            }

            if (entity == 30) {
                categories.add("Artikel");
            }

            if (entity == 31) {
                categories.add("Podcast");
            }

            if (entity == 32) {
                categories.add("Video");
            }

            if (entity == 93) {
                categories.add("Ja' hör mal Gabi!");
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


}
