package de.heallife.app.views.home;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import de.heallife.app.builders.PostView;
import de.heallife.app.data.entity.PostMetaService;
import de.heallife.app.data.entity.QehrgPost;
import de.heallife.app.data.service.CategoryService;
import de.heallife.app.data.service.library.SearchService;
import de.heallife.app.views.MainLayout;
import org.atmosphere.config.service.Post;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import java.util.List;

@Route(value = "search/result", layout = MainLayout.class)
@PermitAll
public class SearchResultView extends VerticalLayout implements HasUrlParameter<String> {

    private SearchService searchService;
    private PostMetaService postMetaService;
    private VerticalLayout main;
    private H1 title;

    @Inject
    public SearchResultView(SearchService service, PostMetaService postMetaService) {
            this.searchService = service;
            this.postMetaService = postMetaService;

        }

        private Image titleImage;

        private VerticalLayout buildPosts(String s) {
            VerticalLayout list = new VerticalLayout();

            try {
                List<QehrgPost> posts = searchService.getFromSearch(s);

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

            } catch (NullPointerException e) {
                Notification notification = new Notification("Keine Inhalte mit dem Schlüsselwort gefunden");
                notification.setDuration(3000);
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                notification.open();
            }

            return list;
        }

    @Override
    public void setParameter(BeforeEvent beforeEvent, String s) {

        main = new VerticalLayout();
        title = new H1("");
        title.setId("title");
        main.add(title);

        title.setText("Deine Suchergebnisse für: " + s);

        add(main, buildPosts(s));
    }
}
