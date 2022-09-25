package de.heallife.app.views.blog;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouteConfiguration;
import de.heallife.app.builders.PostView;
import de.heallife.app.data.entity.PostMetaService;
import de.heallife.app.data.entity.Post;
import de.heallife.app.data.service.CategoryService;
import de.heallife.app.views.MainLayout;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.annotation.security.PermitAll;
import java.text.ParseException;
import java.util.List;

@PageTitle("Blog")
@Route(value = "blog", layout = MainLayout.class)
@PermitAll
@CssImport("./themes/heallifeapp/views/blogView.css")
public class BlogView extends VerticalLayout implements DateFormatView {

    private H1 title;
    private CategoryService categoryService;
    private VerticalLayout main;
    private PostMetaService postMetaService;

    public BlogView(CategoryService categoryService, PostMetaService postMetaService) throws ParseException {
        this.categoryService = categoryService;
        this.postMetaService = postMetaService;

        main = new VerticalLayout();
        title = new H1("");
        title.setId("title");

        title.setText("Neuste Inhalte");

        

        setWidth("100%");
        setPadding(false);
        setSpacing(false);
        add(buildPosts());
    }

    private Image titleImage;

    private VerticalLayout buildPosts() {

        List<Post> posts = categoryService.getAllPosts();
        VerticalLayout list = new VerticalLayout();

        list.getStyle().set("margin-top", "1rem");

        for (int i = posts.size()-1; i > posts.size()/2; i--) {

            HorizontalLayout postLayout = new HorizontalLayout();

      if (first) {
                first = false;
                postLayout.getStyle().set("margin-top", "1rem");
            }

            try {
                 titleImage = new Image(postMetaService.findFeaturedImage(posts.get(i).getId()), "titleImage");
                 titleImage.addClassName("titleImage");
                 title.getElement().setAttribute("loading", "lazy");
            } catch (NumberFormatException e) {
                titleImage = new Image("/images/events/cupofnothing.jpg", "titleImage");
                titleImage.addClassName("titleImage");

            }


            Paragraph meta = new Paragraph();
            meta.setClassName("meta");

            try {
                meta.setText(formatDate(posts.get(i).getPostDate()));
            } catch (ParseException e) {
                e.printStackTrace();
                meta.setText("Heute neu Veröffentlicht");
            }

            H1 title = new H1(posts.get(i).getPostTitle());
            title.addClassName("post-title");

            VerticalLayout textComponent = new VerticalLayout();
            textComponent.addClassName("metaHold");
            textComponent.add(title, meta);
      postLayout.add(titleImage, textComponent);

            int finalI = i;
            postLayout.addClickListener(click -> {

                String route = RouteConfiguration.forSessionScope()
                        .getUrl(PostView.class, posts.get(finalI).getId());

                postLayout.getUI().ifPresent(ui -> ui.navigate(route));

            });

      postLayout.addClassName("postSection");
      list.add(postLayout);
    }

        list.getStyle().set("margin-top", "-1rem");

        return list;
    }

    private int pageableCounter = 0;
    private boolean first = true;

    private VerticalLayout buildBlogPostsNew() throws ParseException {
        // the, currently, newest post is: meditation eine reise ans meer
        Pageable paging = PageRequest.of(pageableCounter, 5);
        Page<Post> pagedPosts = categoryService.getAllPostsOrderByNewest(paging);
        pageableCounter++;

        VerticalLayout parentList = new VerticalLayout();
        parentList.setPadding(false);
        parentList.setSpacing(false);

        for (Post post : pagedPosts) {

            VerticalLayout postLayout = new VerticalLayout();

            VerticalLayout overlayHolder = new VerticalLayout();
            overlayHolder.addClassName("overlay");

            postLayout.setClassName("postElement");
            overlayHolder.addClassName("postElement");
            postLayout.getStyle().set("background-image", "url(" + postMetaService.findFeaturedImage(post.getId()) + ")");
            postLayout.getStyle().set("background-size", "cover");
            postLayout.setPadding(false);

            Div postTitle = new Div();
            H3 postTitleElement = new H3(post.getPostTitle());
            postTitleElement.getStyle().set("margin-top", "15px!important");
            postTitleElement.setClassName("postTitle");
            postTitleElement.getElement().setAttribute("lang", "de");


            Paragraph meta = new Paragraph();
            meta.setClassName("meta");


            try {
                meta.setText(formatDate(post.getPostDate()));
            } catch (ParseException e) {
                e.printStackTrace();
                meta.setText("Heute neu Veröffentlicht");
            }

            Paragraph description = new Paragraph();
            description.setClassName("meta");
            description.setText(post.getPostExcerpt());

            if (post.getPostExcerpt().isEmpty()) {
                overlayHolder.add(postTitleElement, meta);
            } else {
                postTitle.add(postTitleElement, meta);
                meta.addClassName("meta-split");
                overlayHolder.add(postTitle, description);
            }

            if (first) {
                first = false;
                postLayout.setHeight("58vh");
                overlayHolder.setHeight("58vh");
            }

            postLayout.add(overlayHolder);
            parentList.add(postLayout);

            postLayout.addClickListener(click -> {

                String route = RouteConfiguration.forSessionScope()
                        .getUrl(PostView.class, post.getId());

                postLayout.getUI().ifPresent(ui -> ui.navigate(route));

            });

        }

        return parentList;
    }

}
