package de.wpwa.app.data.service.library;

import de.wpwa.app.data.entity.Post;
import de.wpwa.app.data.service.CategoryService;
import de.wpwa.app.security.PostService;
import java.util.List;
import javax.inject.Inject;

import org.springframework.stereotype.Service;

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
