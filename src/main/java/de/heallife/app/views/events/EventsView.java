package de.heallife.app.views.events;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.router.Route;
import de.heallife.app.views.MainLayout;

import javax.annotation.security.PermitAll;

/**
 * A Designer generated component for the events-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("events-view")
@JsModule("./views/events/events-view.ts")
@CssImport("./views/events/events-view.css")
@Route(value = "events", layout = MainLayout.class)
@PermitAll
public class EventsView extends LitTemplate {

    /**
     * Creates a new EventsView.
     */
    public EventsView() {
        // You can initialise any data required for the connected UI components here.
    }

}
