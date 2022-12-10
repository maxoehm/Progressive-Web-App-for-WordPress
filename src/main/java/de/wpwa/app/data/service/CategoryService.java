package de.wpwa.app.data.service;

import de.wpwa.app.data.entity.Post;
import de.wpwa.app.data.entity.TermRelationship;
import de.wpwa.app.data.repositories.TermRelationshipRepository;
import de.wpwa.app.security.PostService;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

  private PostService postService;
  private TermRepository termRepository;
  private TermRelationshipRepository termRelationshipRepository;

  @Inject
  public CategoryService(
      PostService postService,
      TermRepository termRepository,
      TermRelationshipRepository termRelationshipRepository) {
    this.postService = postService;
    this.termRepository = termRepository;
    this.termRelationshipRepository = termRelationshipRepository;
  }

  @PersistenceContext private EntityManager em;

  public List<String> getCategories(Post post) {

    List<TermRelationship> resultList =
        termRelationshipRepository.findTermRelationshipsByIdObjectId(Long.valueOf(post.getId()));

    List<String> categories = new ArrayList<>();

    for (TermRelationship objects : resultList) {

      var entity = objects.getId().getTermTaxonomyId();

      if (entity == 18) {
        categories.add("Category");
      } else if (entity == 94) {
        categories.add("Category");
      } else if (entity == 22) {
        categories.add("Category");
      } else if (entity == 23) {
        categories.add("Category");
      } else if (entity == 25) {
        categories.add("Category");
      } else if (entity == 26) {
        categories.add("Category");
      } else if (entity == 27) {
        categories.add("Category");
      } else if (entity == 28) {
        categories.add("Category");
      } else if (entity == 29) {
        categories.add("Category");
      } else if (entity == 30) {
        categories.add("Category");
      } else if (entity == 31) {
        categories.add("Category");
      } else if (entity == 32) {
        categories.add("Category");
      } else if (entity == 95) {
        categories.add("Category");
      } else if (entity == 96) {
        categories.add("Category");
      } else if (entity == 49) {
        categories.add("Category");
      } else if (entity == 93) {
        categories.add("Category");
      }
      if (entity == 97) {
        categories.add("Category");
      }
    }

    return categories;
  }

  public enum CATEGORY {
    Category1(97L),
    Category2(49L),
    Category3(18L);

    private Long mapping;

    CATEGORY(Long mapping) {
      this.mapping = mapping;
    }

    public Long getMapping() {
      return mapping;
    }
  }

  public boolean isInCategory(CATEGORY category, Post post) {

    for (TermRelationship qr :
        termRelationshipRepository.findTermRelationshipsByIdObjectId(Long.valueOf(post.getId()))) {
      if (qr.getId().getTermTaxonomyId().equals(101L)) {
        return true;
      }
    }

    return false;
  }

  public List<Post> getAllPostsByCategory(CATEGORY category) {

    List<TermRelationship> da =
        termRelationshipRepository.findAllById_TermTaxonomyId(category.getMapping());
    List<Post> posts = new ArrayList<>();

    for (TermRelationship TermRelationship : da) {
      var b =
          postService.getPostByIdAndPostStatus(
              Math.toIntExact(TermRelationship.getId().getObjectId()), "publish");

      if (b != null) {
        posts.add(b);
      }
    }

    return posts;
  }

  public List<Post> getAllPosts() {
    return postService.getPost("post", "publish");
  }

  public Page<Post> getAllPostsOrderByNewest(Pageable paging) {
    return postService.getPostByNewest("post", "publish", paging);
  }
}
