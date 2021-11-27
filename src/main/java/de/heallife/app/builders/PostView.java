package de.heallife.app.builders;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.*;
import de.heallife.app.data.entity.QehrgPost;
import de.heallife.app.data.service.QehrgPostRepository;
import de.heallife.app.security.PostService;
import de.heallife.app.views.MainLayout;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.security.PermitAll;
import java.util.Optional;

/**
 * A Designer generated component for the post-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@PermitAll
@Route(value = "post", layout = MainLayout.class)
@Tag("post-view")
@JsModule("./views/home/post-view.ts")
@CssImport("./views/home/post.css")
public class PostView extends LitTemplate implements HasUrlParameter<Integer> {

    /**
     * Creates a new PostView.
     */

    private Integer objectId;
    private PostService service;
    @Id("h1")
    private H1 h1;
    @Id("div")
    private Div div;

    private Html html;
    private Optional<QehrgPost> post;

    public PostView(PostService service) {
        // You can initialise any data required for the connected UI components here.
        this.service = service;

    }


    @Override
    public void setParameter(BeforeEvent event, Integer parameter) {
        objectId = parameter;

        post = service.getPostById(parameter);

        h1.setText(post.get().getPostTitle());

        try {
            html = new Html("<div>" + post.get().getPostContent() + "</div>");
        } catch (IllegalArgumentException e) {
            html = new Html("<div><p>Ein fehler ist in der Darstellung aufgetreten, um dieses Problem zu lösen schau dir den Post online an.</p> <a href=\"" + post.get().getGuid() + "\">Link zum Post</a> </div>");
        }

        div.setWidth("85%");
        div.add(html);

    }

    private void applyChanges() {

    }


}
