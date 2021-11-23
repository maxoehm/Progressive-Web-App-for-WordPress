package de.heallife.app.data.service;

import de.heallife.app.data.entity.QehrgPost;
import de.heallife.app.security.PostService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

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

        String query = "select * from qehrg_term_relationships as u where u.objectid = :vx";
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




}
