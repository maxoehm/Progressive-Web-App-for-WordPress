package de.heallife.app.views.login;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.server.communication.PwaHandler;
import de.heallife.app.views.MainLayout;

import javax.annotation.security.PermitAll;


@Route(value = "start", layout = MainLayout.class)
@AnonymousAllowed
@CssImport("./themes/heallifeapp/views/install-view.css")
public class StartView extends FlexLayout implements HasUrlParameter<String>  {

    private String browser = "";
    private VerticalLayout mainLayout;
    private HorizontalLayout horizontalLayout;
    private VerticalLayout main;

    public StartView() {

        mainLayout = new VerticalLayout();
        horizontalLayout = new HorizontalLayout();
        main = new VerticalLayout();

        H1 title = new H1("Installiere unsere App");
        title.setId("title");

        mainLayout.setId("mainLayout");
        horizontalLayout.add(title);

        add(mainLayout);
    }


    @Override
    public void setParameter(BeforeEvent beforeEvent, String parameter) {
        if (parameter.equals("install")) {


             if (UI.getCurrent().getSession().getBrowser().isAndroid()) {

                 if (UI.getCurrent().getSession().getBrowser().isChrome()) {
                     buildChorome();
                 }
                 else if (UI.getCurrent().getSession().getBrowser().isEdge()) {
                 } else {
                 }

             } else if (UI.getCurrent().getSession().getBrowser().isSafari()) {
                 buildIos();
             }

        }
    }

    private void buildIos() {

        Icon home = new Icon("heallife","arrow-up");
        home.addClassName("rotated");

        Paragraph step1 = new Paragraph("1. Bitte auf den Teilen -Button unten auf deinem Bildschirm");
        step1.addClassName("step");
        Paragraph step2 = new Paragraph("2. Klicke auf 'Zum Home-Bildschirm hinzufügen'");
        step2.addClassName("step");
        Paragraph step3 = new Paragraph("3. Öffne die App von deinem Home-Bildschirm aus");
        step3.addClassName("step");

        main.add(step1, step2, step3);
        horizontalLayout.add(home);
        mainLayout.add(horizontalLayout, main);

        home.getStyle().set("justify-content", "center");
        add(home);
    }

    private void buildChorome() {

        Icon home = new Icon("heallife","arrow-up");
        home.addClassName("bounce");

        Paragraph step1 = new Paragraph("1. Bitte auf die drei Punkte oben rechts auf deinem Bildschirm");
        step1.addClassName("step");
        Paragraph step2 = new Paragraph("2. Klicke auf App installieren");
        step2.addClassName("step");
        Paragraph step3 = new Paragraph("3. Öffne die App von deinem Home-Bildschirm aus");
        step3.addClassName("step");

        main.add(home, step1, step2, step3);
        horizontalLayout.add(home);

        mainLayout.add(horizontalLayout, main);
    }
}
