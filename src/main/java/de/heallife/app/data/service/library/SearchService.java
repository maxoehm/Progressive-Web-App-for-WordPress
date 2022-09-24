package de.heallife.app.data.service.library;

import de.heallife.app.data.entity.Post;
import de.heallife.app.data.service.CategoryService;
import de.heallife.app.security.PostService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class SearchService {

    private CategoryService categoryService;
    private PostService postService;

    @Inject
    public SearchService(CategoryService categoryService, PostService postService) {
        this.categoryService = categoryService;
        this.postService = postService;
    }


    public List<Post> getFromSearch(String s) {
        return postService.searchByString(s);
    }
}
