package de.wpwa.app.views.categories;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteConfiguration;
import de.wpwa.app.builders.PostView;
import de.wpwa.app.data.entity.Post;
import de.wpwa.app.data.entity.PostMetaService;
import de.wpwa.app.data.service.CategoryService;
import de.wpwa.app.views.MainLayout;

import java.util.Collections;
import java.util.List;
import javax.annotation.security.PermitAll;

@Route(value = "category", layout = MainLayout.class)
@CssImport("./views/categories/category-view.css")
@PermitAll
public class CategoryView extends FlexLayout implements HasUrlParameter<String> {

  private String parameter;

  private H1 title;
  private CategoryService categoryService;
  private VerticalLayout main;
  private PostMetaService postMetaService;

  public CategoryView(CategoryService categoryService, PostMetaService postMetaService) {
    this.categoryService = categoryService;
    this.postMetaService = postMetaService;

    main = new VerticalLayout();
    title = new H1("");
    title.setId("title");
    main.add(title);

    add(main);
  }

  @Override
  public void setParameter(BeforeEvent event, String parameter) {

    title.setText(parameter.replaceAll("_", " "));
    main.add(buildPosts(Enum.valueOf(CategoryService.CATEGORY.class, parameter)));
  }

  private VerticalLayout buildPosts(CategoryService.CATEGORY category) {

    List<Post> posts = categoryService.getAllPostsByCategory(category);
    Collections.reverse(posts);

    VerticalLayout list = new VerticalLayout();

    for (Post post : posts) {
      HorizontalLayout postLayout = new HorizontalLayout();

      Image titleImage = new Image(postMetaService.findFeaturedImage(post.getId()), "titleImage");
      titleImage.addClassName("titleImage");
      H1 title = new H1(post.getPostTitle());
      title.addClassName("post-title");
      postLayout.add(titleImage, title);

      postLayout.addClickListener(
          click -> {
            String route =
                RouteConfiguration.forSessionScope().getUrl(PostView.class, post.getId());

            postLayout.getUI().ifPresent(ui -> ui.navigate(route));
          });

      postLayout.getStyle().set("margin-top", "1rem");
      list.add(postLayout);
    }

    return list;
  }
}
