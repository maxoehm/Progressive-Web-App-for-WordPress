package de.heallife.app.views.home;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import de.heallife.app.data.QehrgUser;
import de.heallife.app.data.service.QehrgUserService;
import de.heallife.app.views.MainLayout;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;

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

    @Id("vaadinVerticalLayout")
    private VerticalLayout vaadinVerticalLayout;

    /**
     * Creates a new HomeView.
     */

    private QehrgUserService qehrgUserService;

    @Inject
    public HomeView(QehrgUserService qehrgUserService) {
        // You can initialise any data required for the connected UI components here.
        this.qehrgUserService = qehrgUserService;

        TextField textField = new TextField("Query");
        Button button = new Button("LookUp");
        TextField result = new TextField("Result");
        result.setReadOnly(true);

        button.addClickListener(event -> {
            QehrgUser user = qehrgUserService.getUserByNiceName(textField.getValue());
            result.setValue(user.getUserEmail());
        });



        vaadinVerticalLayout.add(textField, button, result);

    }

}
