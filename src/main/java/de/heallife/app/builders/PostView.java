package de.heallife.app.builders;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.router.*;
import de.heallife.app.data.entity.QehrgPost;
import de.heallife.app.data.service.QehrgPostRepository;
import de.heallife.app.views.MainLayout;

import java.util.Optional;

/**
 * A Designer generated component for the post-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("post-view")
@JsModule("./views/home/post-view.ts")
@Route(value = "post/:postId?/view", layout = MainLayout.class)
public class PostView extends LitTemplate implements HasUrlParameter<Integer> {

    /**
     * Creates a new PostView.
     */

    private Integer objectId;
    private QehrgPostRepository postRepository;


    public PostView(QehrgPostRepository postRepository) {
        // You can initialise any data required for the connected UI components here.
        this.postRepository = postRepository;

        var post = postRepository.findById(objectId);


    }



    @Override
    public void setParameter(BeforeEvent beforeEvent, Integer integer) {
        objectId = integer;
    }
}
