package de.heallife.app.data.service.library;

import de.heallife.app.data.entity.QehrgPost;
import de.heallife.app.data.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    private CategoryService categoryService;

    @Inject
    public SearchService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    public List<QehrgPost> getFromSearch(String s) {
        List<QehrgPost> searchList = categoryService.getAllPosts();
        List<QehrgPost> finalList = new ArrayList<>();


        for (QehrgPost post : searchList) {
            if (post.getPostTitle().contains(s) || post.getPostContent().contains(s) || String.valueOf(post.getPostDate()).equals(s) || String.valueOf(post.getPostDate()).contains(s)) {
                  finalList.add(post);
            }
        }

        return finalList;
    }
}
