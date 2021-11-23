package de.heallife.app.views.home;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import de.heallife.app.data.QehrgUser;
import de.heallife.app.data.entity.QehrgPost;
import de.heallife.app.data.service.CategoryService;
import de.heallife.app.data.service.QehrgUserService;
import de.heallife.app.security.PostService;
import de.heallife.app.views.MainLayout;
import org.aspectj.weaver.ast.Not;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
@PermitAll
@AnonymousAllowed
public class HomeView extends LitTemplate {

    /**
     * Creates a new HomeView.
     */

    @Id("box1")
    private VerticalLayout box1;
    @Id("box2")
    private VerticalLayout box2;


    private CategoryService categoryService;
    private PostService postService;
    private int i = 0;


    @Inject
    public HomeView(PostService postService, CategoryService categoryService) {
        // You can initialise any data required for the connected UI components here.
        this.postService = postService;
        this.categoryService = categoryService;

        TextArea textArea = new TextArea();
        textArea.setWidth("100%");

        TextArea taxonomyInformation = new TextArea();
        taxonomyInformation.setWidth("100%");

        box1.add(textArea, taxonomyInformation);

        TextArea textArea1 = new TextArea();

        List<QehrgPost> postList = postService.getPost("post", "publish");

        textArea.setValue(String.valueOf(postList.get(i).getPostName()));
        textArea1.setValue(postList.get(i).getId().toString());
     //   taxonomyInformation.setValue(categoryService.getCategory(postList).toString());
        textArea.setWidth("100%");

        categoryService.getCategoryTest(postList.get(i++));

        Button button = new Button("Next");
        box2.add(textArea1, button);

        button.addClickListener(event -> {
            textArea.setValue(String.valueOf(postList.get(i++).getPostName()));
            textArea1.setValue(postList.get(i).getId().toString());
   //         taxonomyInformation.setValue(categoryService.getCategory(postList).toString());

        });


    }

}
