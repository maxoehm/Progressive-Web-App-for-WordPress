package de.heallife.app.views.home;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import de.heallife.app.views.MainLayout;

import javax.annotation.security.PermitAll;

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
public class HomeView extends LitTemplate {

    @Id("vaadinVerticalLayout")
    private Element vaadinVerticalLayout;

    /**
     * Creates a new HomeView.
     */
    public HomeView() {
        // You can initialise any data required for the connected UI components here.



    }

}
