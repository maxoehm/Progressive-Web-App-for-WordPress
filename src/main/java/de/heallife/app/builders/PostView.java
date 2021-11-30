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
import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

            var postContent = post.get().getPostContent();

            if (postContent.contains("youtu")) {
                postContent = getAllLinksFromTheText(postContent);
            }

            html = new Html("<div>" + postContent + "</div>");
        } catch (IllegalArgumentException e) {
            html = new Html("<div><p>Ein fehler ist in der Darstellung aufgetreten, um dieses Problem zu lösen schau dir den Post online an.</p> <a href=\"" + post.get().getGuid() + "\">Link zum Post</a> </div>");
        }

        div.setWidth("85%");
        div.add(html);

    }

    private static final String LINK_REGEX = "((http:\\/\\/|https:\\/\\/)?(www.)?(([a-zA-Z0-9-]){2,2083}\\.){1,4}([a-zA-Z]){2,6}(\\/(([a-zA-Z-_\\/\\.0-9#:?=&;,]){0,2083})?){0,2083}?[^ \\n]*)";

    private String getAllLinksFromTheText(String text) {
        Pattern p = Pattern.compile(LINK_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(text);

        if (m.find()) {

            var s = m.find() ? m.group(1) : "";

            s = s.replaceAll("youtu.be", "youtube.com/embed");

            var iFrameA = "<iframe width=\"100%\" height=\"auto\" style=\"margin-left: -2rem;\" src=\"";
            var iFrameB = "\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>";
            return m.replaceAll(iFrameA + s + iFrameB);
        }
        return text;
    }




}
