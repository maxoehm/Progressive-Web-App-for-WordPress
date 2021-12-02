package de.heallife.app.views.blog;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouteConfiguration;
import de.heallife.app.builders.PostView;
import de.heallife.app.data.entity.PostMetaService;
import de.heallife.app.data.entity.QehrgPost;
import de.heallife.app.data.service.CategoryService;
import de.heallife.app.views.MainLayout;
import javax.annotation.security.PermitAll;
import java.util.List;

@PageTitle("Blog")
@Route(value = "blog", layout = MainLayout.class)
@PermitAll
public class BlogView extends VerticalLayout {

    private H1 title;
    private CategoryService categoryService;
    private VerticalLayout main;
    private PostMetaService postMetaService;

    public BlogView(CategoryService categoryService, PostMetaService postMetaService) {
        this.categoryService = categoryService;
        this.postMetaService = postMetaService;

        main = new VerticalLayout();
        title = new H1("");
        title.setId("title");
        main.add(title);

        title.setText("Neuste Inhalte");

        add(main, buildPosts());
    }

    private Image titleImage;

    private VerticalLayout buildPosts() {

        List<QehrgPost> posts = categoryService.getAllPosts();
        VerticalLayout list = new VerticalLayout();

        for (int i = posts.size()-1; i > 0; i--) {
            HorizontalLayout postLayout = new HorizontalLayout();

            try {
                 titleImage = new Image(postMetaService.findFeaturedImage(posts.get(i).getId()), "titleImage");
                 titleImage.addClassName("titleImage");
            } catch (NumberFormatException e) {
                titleImage = new Image("/images/events/cupofnothing.jpg", "titleImage");
                titleImage.addClassName("titleImage");

            }


            H1 title = new H1(posts.get(i).getPostTitle());
            title.addClassName("post-title");
            postLayout.add(titleImage, title);

            int finalI = i;
            postLayout.addClickListener(click -> {

                String route = RouteConfiguration.forSessionScope()
                        .getUrl(PostView.class, posts.get(finalI).getId());

                postLayout.getUI().ifPresent(ui -> ui.navigate(route));

            });

            postLayout.getStyle().set("margin-top", "1rem");
            list.add(postLayout);
        }

        list.getStyle().set("margin-top", "-1rem");

        return list;
    }

}
