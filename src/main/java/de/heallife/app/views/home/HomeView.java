package de.heallife.app.views.home;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouteConfiguration;
import de.heallife.app.views.MainLayout;
import de.heallife.app.views.categories.CategoryView;

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
@CssImport("./themes/heallifeapp/views/homeView.css")
@PermitAll
public class HomeView extends LitTemplate {

    @Id("h1")
    private H1 h1;
    @Id("c1")
    private VerticalLayout c1;
    @Id("vaadinVerticalLayout")
    private VerticalLayout vaadinVerticalLayout;
    @Id("vaadinVerticalLayout1")
    private VerticalLayout vaadinVerticalLayout1;
    @Id("vaadinVerticalLayout2")
    private VerticalLayout vaadinVerticalLayout2;
    @Id("vaadinVerticalLayout3")
    private VerticalLayout vaadinVerticalLayout3;
    @Id("vaadinVerticalLayout4")
    private VerticalLayout vaadinVerticalLayout4;
    @Id("vaadinVerticalLayout5")
    private VerticalLayout vaadinVerticalLayout5;
    @Id("vaadinVerticalLayout6")
    private VerticalLayout vaadinVerticalLayout6;
    @Id("vaadinVerticalLayout7")
    private VerticalLayout vaadinVerticalLayout7;


    @Inject
    public HomeView() {
        // You can initialise any data required for the connected UI components here.

        h1.setText("Entdecken");

        c1.addClickListener(event -> {
            String route = RouteConfiguration.forSessionScope()
                    .getUrl(CategoryView.class, "Allgemeinwissen");
            c1.getUI().ifPresent(ui -> ui.navigate(route));
        });

        vaadinVerticalLayout.addClickListener(event -> {
            String route = RouteConfiguration.forSessionScope()
                    .getUrl(CategoryView.class, "Gezielte Bewegung");
            vaadinVerticalLayout.getUI().ifPresent(ui -> ui.navigate(route));
        });

        vaadinVerticalLayout1.addClickListener(event -> {
            String route = RouteConfiguration.forSessionScope()
                    .getUrl(CategoryView.class, "Freizeit");
            vaadinVerticalLayout1.getUI().ifPresent(ui -> ui.navigate(route));
        });

        vaadinVerticalLayout2.addClickListener(event -> {
            String route = RouteConfiguration.forSessionScope()
                    .getUrl(CategoryView.class, "Lifestyle");
            vaadinVerticalLayout2.getUI().ifPresent(ui -> ui.navigate(route));
        });

        vaadinVerticalLayout3.addClickListener(event -> {
            String route = RouteConfiguration.forSessionScope()
                    .getUrl(CategoryView.class, "Meditation");
            vaadinVerticalLayout3.getUI().ifPresent(ui -> ui.navigate(route));
                });

        vaadinVerticalLayout4.addClickListener(event -> {
            String route = RouteConfiguration.forSessionScope()
                    .getUrl(CategoryView.class, "Seelische und mentale Gesundheit");
            vaadinVerticalLayout4.getUI().ifPresent(ui -> ui.navigate(route));
                });

        vaadinVerticalLayout5.addClickListener(event -> {
            String route = RouteConfiguration.forSessionScope()
                    .getUrl(CategoryView.class, "Ernährung");
            vaadinVerticalLayout5.getUI().ifPresent(ui -> ui.navigate(route));
                });

        vaadinVerticalLayout6.addClickListener(event -> {
            String route = RouteConfiguration.forSessionScope()
                    .getUrl(CategoryView.class, "Yoga");
            vaadinVerticalLayout6.getUI().ifPresent(ui -> ui.navigate(route));
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
