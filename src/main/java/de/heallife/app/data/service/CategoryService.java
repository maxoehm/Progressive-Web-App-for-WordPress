package de.heallife.app.data.service;

import de.heallife.app.data.entity.Post;
import de.heallife.app.data.entity.QehrgTermRelationship;
import de.heallife.app.data.repositories.QehrgTermRelationshipRepository;
import de.heallife.app.security.PostService;
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
  private QehrgTermRepository termRepository;
  private QehrgTermRelationshipRepository termRelationshipRepository;

  @Inject
  public CategoryService(
      PostService postService,
      QehrgTermRepository termRepository,
      QehrgTermRelationshipRepository termRelationshipRepository) {
    this.postService = postService;
    this.termRepository = termRepository;
    this.termRelationshipRepository = termRelationshipRepository;
  }

  @PersistenceContext private EntityManager em;

  public List<String> getCategories(Post post) {

    List<QehrgTermRelationship> resultList =
        termRelationshipRepository.findQehrgTermRelationshipsByIdObjectId(
            Long.valueOf(post.getId()));

    List<String> categories = new ArrayList<>();

    for (QehrgTermRelationship objects : resultList) {

      var entity = objects.getId().getTermTaxonomyId();

      if (entity == 18) {
        categories.add("Mediathek");
      } else if (entity == 94) {
        categories.add("Gezielte Bewegung");
      } else if (entity == 22) {
        categories.add("Lifestyle");
      } else if (entity == 23) {
        categories.add("Yoga");
      } else if (entity == 25) {
        categories.add("Freizeit");
      } else if (entity == 26) {
        categories.add("Ernährung");
      } else if (entity == 27) {
        categories.add("Meditation");
      } else if (entity == 28) {
        categories.add("Allgemeinwissen");
      } else if (entity == 29) {
        categories.add("Empfehlungen");
      } else if (entity == 30) {
        categories.add("Artikel");
      } else if (entity == 31) {
        categories.add("Podcast");
      } else if (entity == 32) {
        categories.add("Video");
      } else if (entity == 95) {
        categories.add("Events");
      } else if (entity == 96) {
        categories.add("Events Online");
      } else if (entity == 49) {
        categories.add("Seelische und mentale Gesundheit");
      } else if (entity == 93) {
        categories.add("Ja' hör mal Gabi!");
      }
      if (entity == 97) {
        categories.add("Physische Gesundheit");
      }
    }

    return categories;
  }

  public enum CATEGORY {
    Physische_Gesundheit(97L),
    Seelische_und_mentale_Gesundheit(49L),
    Mediathek(18L),
    Gezielte_Bewegung(94L),
    Lifestyle(22L),
    Yoga(23L),
    Freizeit(25L),
    Ernährung(26L),
    Meditation(27L),
    Allgemeinwissen(28L),
    Empfehlungen(29L),
    Artikel(30L),
    Podcast(31L),
    Video(32L),
    Events(95L),
    Events_Online(96L),
    Ja_hör_mal_Gabi(93L),
    Spendenaktion(98L),
    Challenges(101L);

    private Long mapping;

    CATEGORY(Long mapping) {
      this.mapping = mapping;
    }

    public Long getMapping() {
      return mapping;
    }
  }

  public boolean isInCategory(CATEGORY category, Post post) {

    for (QehrgTermRelationship qr :
        termRelationshipRepository.findQehrgTermRelationshipsByIdObjectId(
            Long.valueOf(post.getId()))) {
      if (qr.getId().getTermTaxonomyId().equals(101L)) {
        return true;
      }
    }

    return false;
  }

  public List<Post> getAllPostsByCategory(CATEGORY category) {

    List<QehrgTermRelationship> da =
        termRelationshipRepository.findAllById_TermTaxonomyId(category.getMapping());
    List<Post> posts = new ArrayList<>();

    for (QehrgTermRelationship qehrgTermRelationship : da) {
      var b =
          postService.getPostByIdAndPostStatus(
              Math.toIntExact(qehrgTermRelationship.getId().getObjectId()), "publish");

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
