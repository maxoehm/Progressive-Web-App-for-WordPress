package de.heallife.app.views.events;


import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import de.heallife.app.security.PostService;
import de.heallife.app.views.MainLayout;

import javax.annotation.security.PermitAll;

@Route(value = "content", layout = MainLayout.class)
@PermitAll
@JsModule("./views/home/post-view.ts")
@CssImport("./views/home/post.css")
public class EventsContentView extends FlexLayout implements HasUrlParameter<String> {

    private Integer objectId;
    private PostService service;
    @Id("h1")
    private H1 h1;
    @Id("div")
    private Div div;


    @Override
    public void setParameter(BeforeEvent event, String parameter) {


    }

}
