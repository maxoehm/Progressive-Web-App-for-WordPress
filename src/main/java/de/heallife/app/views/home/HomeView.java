package de.heallife.app.views.home;

import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import de.heallife.app.views.MainLayout;
import com.vaadin.flow.router.RouteAlias;
import javax.annotation.security.PermitAll;

@PageTitle("Home")
@Route(value = "home", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@JsModule("./views/home/home-view.ts")
@PermitAll
public class HomeView extends VerticalLayout {

    public HomeView() {

    }

}
