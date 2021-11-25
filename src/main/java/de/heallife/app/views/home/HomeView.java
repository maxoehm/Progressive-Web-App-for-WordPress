package de.heallife.app.views.home;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import de.heallife.app.builders.PostView;
import de.heallife.app.data.entity.QehrgPost;
import de.heallife.app.data.service.CategoryService;
import de.heallife.app.security.AuthenticatedUser;
import de.heallife.app.security.PostService;
import de.heallife.app.views.MainLayout;
import de.heallife.app.views.categories.CategoryView;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import java.util.List;


/**
 * A Designer generated component for the home-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("home-view")
@Route(value = "home", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@JsModule("./views/home/home-view.ts")
@CssImport("./themes/heallifeapp/views/homeView.css")
@PermitAll
@AnonymousAllowed
public class HomeView extends LitTemplate {

    /**
     * Creates a new HomeView.
     */


    private CategoryService categoryService;
    private PostService postService;
    private AuthenticatedUser authenticatedUser;
    private int i = 0;

    @Id("h1")
    private H1 h1;
    @Id("c1")
    private VerticalLayout c1;


    @Inject
    public HomeView(PostService postService, CategoryService categoryService, AuthenticatedUser authenticatedUser) {
        // You can initialise any data required for the connected UI components here.
        this.postService = postService;
        this.categoryService = categoryService;
        this.authenticatedUser = authenticatedUser;

        h1.setText("Discover");

        List<QehrgPost> postList = postService.getPost("post", "publish");

        var categories = categoryService.getCategories(postList.get(i+1));

        String categoriesListString = "";

        for (var category : categories) {

            categoriesListString = categoriesListString + ", " + categories.get(i).toString();

        }

        String route = RouteConfiguration.forSessionScope()
                .getUrl(CategoryView.class, "Kraft");

        c1.addClickListener(event -> {
            c1.getUI().ifPresent(ui -> ui.navigate(route));
        });

/*
        String route = RouteConfiguration.forSessionScope()
                .getUrl(PostView.class, postList.get(i+1).getId());

        c1.addClickListener(event -> {
            c1.getUI().ifPresent(ui -> ui.navigate(route));
        });
*/
    }
}
