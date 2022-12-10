package de.wpwa.app.views.events;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteConfiguration;
import de.wpwa.app.builders.PostView;
import de.wpwa.app.views.MainLayout;
import de.wpwa.app.views.categories.CategoryView;

import javax.annotation.security.PermitAll;

/**
 * A Designer generated component for the events-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */

@Route(value = "events", layout = MainLayout.class)
@CssImport("./themes/heallifeapp/views/events-view.css")
@PermitAll
public class EventsView extends FlexLayout {

    /**
     * Creates a new EventsView.
     */

    public EventsView() {
        // You can initialise any data required for the connected UI components here.

        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.add(buildFormLayout(), buildEventsLayout());

        add(mainLayout);

    }


    VerticalLayout buildFormLayout() {
        VerticalLayout layout = new VerticalLayout();

        H1 title = new H1("Consetetur sadipscing");
        title.setId("mainTitle");

        VerticalLayout actionFieldA = new VerticalLayout();
        var subtitleY = new H3("Sadipscing");
        var descriptionY = new Paragraph("At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren.");

        descriptionY.addClassName("description");
        subtitleY.addClassName("subtitle");

        actionFieldA.add(subtitleY, descriptionY);

        VerticalLayout actionFieldB = new VerticalLayout();
        var subtitleG = new H3("Lorem ipsum!");
        var descriptionG = new Paragraph("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor.");

        subtitleG.addClassName("subtitle");
        descriptionG.addClassName("description");

        actionFieldA.addClickListener(event -> {
            String route = RouteConfiguration.forSessionScope()
                    .getUrl(PostView.class, 235109);
            layout.getUI().ifPresent(ui -> ui.navigate(route));
        });

        actionFieldB.addClickListener(event -> {
            String route = RouteConfiguration.forSessionScope()
                    .getUrl(PostView.class, 235698);
            layout.getUI().ifPresent(ui -> ui.navigate(route));
        });

        actionFieldA.setId("actionFieldA");
        actionFieldB.setId("actionFieldB");

        actionFieldA.addClassName("box_cat");
        actionFieldB.addClassName("box_cat");

        actionFieldB.add(subtitleG, descriptionG);
        layout.add(title, actionFieldA, actionFieldB);

        return layout;
    }

    VerticalLayout buildEventsLayout() {
        VerticalLayout layout = new VerticalLayout();

        H1 title = new H1("Events");
        title.setId("mainTitle");

        VerticalLayout local = new VerticalLayout();
        var subtitleY = new H3("In deiner Umgebung");
        var descriptionY = new Paragraph("Hier findest du alle Live Angebote in deiner Umgebung zum Teilnehmen. Hier ist bestimmt für jeden was dabei.");

        descriptionY.addClassName("description");
        subtitleY.addClassName("subtitle");

        local.add(subtitleY, descriptionY);


        local.setId("events_local");

        local.addClassName("box_cat");

        local.addClickListener(event -> {
                String route = RouteConfiguration.forSessionScope()
                        .getUrl(CategoryView.class, "Events");
            layout.getUI().ifPresent(ui -> ui.navigate(route));
            });

        VerticalLayout online = new VerticalLayout();
        var subtitle = new H3("Über das Internet");
        var description = new Paragraph("Hier findest du alle Live Angebote die über das Internet stattfinden.");

        description.addClassName("description");
        subtitle.addClassName("subtitle");

        online.add(subtitle, description);

        online.setId("events");

        online.addClassName("box_cat");

        online.addClickListener(event -> {
            String route = RouteConfiguration.forSessionScope()
                    .getUrl(CategoryView.class, "Events_Online");
            layout.getUI().ifPresent(ui -> ui.navigate(route));
        });

        layout.add(title, local, online);

        return layout;
    }

}


