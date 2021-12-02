package de.heallife.app.views.categories;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.UI;
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
import com.vaadin.flow.server.auth.AnonymousAllowed;
import de.heallife.app.builders.PostView;
import de.heallife.app.data.entity.PostMetaService;
import de.heallife.app.data.entity.QehrgPost;
import de.heallife.app.data.service.CategoryService;
import de.heallife.app.security.PostService;
import de.heallife.app.views.MainLayout;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.security.PermitAll;
import java.util.List;


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

        Html html = new Html("<div><link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n" +
                "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n" +
                "<link href=\"https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,600;1,700;1,800;1,900&amp;display=swap\" rel=\"stylesheet\"></div>");

        main = new VerticalLayout();
        title = new H1("");
        title.setId("title");
        main.add(html, title);

        add(main);
    }

    @Override
    public void setParameter(BeforeEvent event, String parameter) {

        title.setText(parameter);
        main.add(buildPosts(parameter));

    }

    private VerticalLayout buildPosts(String category) {

        List<QehrgPost> posts = categoryService.getPostByCategory("post", "publish", category);
        VerticalLayout list = new VerticalLayout();

        for (QehrgPost post : posts) {
            HorizontalLayout postLayout = new HorizontalLayout();
            Image titleImage = new Image(postMetaService.findFeaturedImage(post.getId()), "titleImage");
            titleImage.addClassName("titleImage");
            H1 title = new H1(post.getPostTitle());
            title.addClassName("post-title");
            postLayout.add(titleImage, title);

            postLayout.addClickListener(click -> {

                String route = RouteConfiguration.forSessionScope()
                        .getUrl(PostView.class, post.getId());

                    postLayout.getUI().ifPresent(ui -> ui.navigate(route));

            });

            postLayout.getStyle().set("margin-top", "1rem");
            list.add(postLayout);
        }

        return list;
    }



}
