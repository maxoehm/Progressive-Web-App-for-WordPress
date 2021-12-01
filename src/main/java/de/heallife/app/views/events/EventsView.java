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
import de.heallife.app.views.MainLayout;

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

        add(buildFormLayout());

    }


    VerticalLayout buildFormLayout() {
        VerticalLayout layout = new VerticalLayout();

        H1 title = new H1("Liveangebote");

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


        yogaNidra.setId("yogaNidra");
        gutenMorgen.setId("gutenMorgen");

        yogaNidra.addClassName("box_cat");
        gutenMorgen.addClassName("box_cat");

        gutenMorgen.add(subtitleG, descriptionG);
        layout.add(title, yogaNidra, gutenMorgen);

        return layout;
    }

}


