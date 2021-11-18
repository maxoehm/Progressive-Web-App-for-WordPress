package de.heallife.app.data.service;

import de.heallife.app.data.QehrgUser;
import de.heallife.app.data.entity.QehrgPost;
import de.heallife.app.data.entity.QehrgTermRelationship;
import de.heallife.app.security.PostService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private PostService postService;
    private QehrgTermRelationshipRepository termRelationshipRepository;
    private QehrgTermRepository termRepository;


    @Inject
    public CategoryService(PostService postService, QehrgTermRelationshipRepository termRelationshipRepository, QehrgTermRepository termRepository) {
        this.postService  = postService;
        this.termRelationshipRepository = termRelationshipRepository;
        this.termRepository = termRepository;

    }

    public List<String> getCategory(QehrgPost post) {

        List<QehrgTermRelationship> termRelationship = termRelationshipRepository.findById1(Long.valueOf(post.getId()));
        List<String> categories = new ArrayList<>();


        for (int i = 0; i < termRelationship.size(); i++) {

            categories.add(termRepository.findById1(termRelationship.get(i).getId2()).get(i).getName());

        }


        return categories;
    }

    public List<String> getCategory(List<QehrgPost> post) {

        List<QehrgTermRelationship> termRelationship = termRelationshipRepository.findById1(Long.valueOf(post.get(0).getId()));
        List<String> categories = new ArrayList<>();


        for (int i = 0; i < termRelationship.size(); i++) {

            categories.add(termRepository.findById1(termRelationship.get(i).getId2()).get(i).getName());

        }


        return categories;
    }


}
