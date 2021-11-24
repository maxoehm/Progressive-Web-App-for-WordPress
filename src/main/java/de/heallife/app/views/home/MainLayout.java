package de.heallife.app.views.home;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.template.Id;

/**
 * A Designer generated component for the main-layout template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("main-layout")
@JsModule("./views/main-layout.ts")
public class MainLayout extends LitTemplate {

    @Id("vaadinHorizontalLayout")
    private HorizontalLayout vaadinHorizontalLayout;

    /**
     * Creates a new MainLayout.
     */
    public MainLayout() {
        // You can initialise any data required for the connected UI components here.
    }

}
