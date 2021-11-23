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

    public List<String> getCategoryTest(QehrgPost post) {


        String query = "select * from qehrg_term_relationships as u where u.objectid = :vx";
        Query q = em.createNativeQuery(query);
        q.setParameter("vx", 635);
        List<Object[]> resultList = q.getResultList();

        resultList.get(0).toString();

        List<String> categories = new ArrayList<>();


        return categories;
    }



}
