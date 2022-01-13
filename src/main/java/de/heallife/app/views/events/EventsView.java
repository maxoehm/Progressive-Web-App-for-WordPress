package de.heallife.app.views.events;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteConfiguration;
import de.heallife.app.builders.PostView;
import de.heallife.app.views.MainLayout;
import de.heallife.app.views.categories.CategoryView;

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

        H1 title = new H1("Liveangebote");
        title.setId("mainTitle");

        VerticalLayout yogaNidra = new VerticalLayout();
        var subtitleY = new H3("Yoga Nidra");
        var descriptionY = new Paragraph("bietet sich als Stressentlastungs-Übung an und wird auch in der Behandlung von Patienten mit Burn-out integriert werden.");

        descriptionY.addClassName("description");
        subtitleY.addClassName("subtitle");

        yogaNidra.add(subtitleY, descriptionY);

        VerticalLayout gutenMorgen = new VerticalLayout();
        var subtitleG = new H3("Guten Morgen, Körper!");
        var descriptionG = new Paragraph("Motiviert, kraftvoll und gesund in den Tag starten, zusammen mit Ina und einer Ladung Energie.");

        subtitleG.addClassName("subtitle");
        descriptionG.addClassName("description");

        yogaNidra.addClickListener(event -> {
            String route = RouteConfiguration.forSessionScope()
                    .getUrl(PostView.class, 235109);
            layout.getUI().ifPresent(ui -> ui.navigate(route));
        });

        gutenMorgen.addClickListener(event -> {
            String route = RouteConfiguration.forSessionScope()
                    .getUrl(PostView.class, 235698);
            layout.getUI().ifPresent(ui -> ui.navigate(route));
        });

        yogaNidra.setId("yogaNidra");
        gutenMorgen.setId("gutenMorgen");

        yogaNidra.addClassName("box_cat");
        gutenMorgen.addClassName("box_cat");

        gutenMorgen.add(subtitleG, descriptionG);
        layout.add(title, yogaNidra, gutenMorgen);

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


