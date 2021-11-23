package de.heallife.app.builders;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import de.heallife.app.data.entity.QehrgPost;

/**
 * A Designer generated component for the post-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("post-view")
@JsModule("./views/home/post-view.ts")
public class PostView extends LitTemplate {

    /**
     * Creates a new PostView.
     */
    public PostView(QehrgPost post) {
        // You can initialise any data required for the connected UI components here.
    }

}
