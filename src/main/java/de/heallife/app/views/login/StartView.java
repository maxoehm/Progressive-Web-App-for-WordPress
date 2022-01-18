package de.heallife.app.views.login;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
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
                 promtKnowHowToNavigate();
                 buildIos();
             }

        }
    }

    private void promtKnowHowToNavigate() {

        ConfirmDialog dialog = new ConfirmDialog();
        dialog.setHeader("Weisst du wie man navigiert?");
        dialog.setText("Weisst du wie man vor und zurück geht, also auf die vorherige Seite kommt?");

        dialog.setCancelText("Ja, weiss ich.");
        dialog.setCancelable(true);
        dialog.addCancelListener(event -> {
                dialog.close();
                });

        dialog.setConfirmText("Nein, zeig mir wie.");
        dialog.addConfirmListener(event -> {
            dialog.close();
            UI.getCurrent().getPage().setLocation("https://youtu.be/H8w1NCkBhV4?t=35");
        });

        add(dialog);
        dialog.open();
    }



    private void buildIos() {

        Paragraph step1 = new Paragraph("1. Klicke auf den Teilen -Button unten auf deinem Bildschirm");
        step1.addClassName("step");
        Paragraph step2 = new Paragraph("2. Klicke auf 'Zum Home-Bildschirm hinzufügen'");
        step2.addClassName("step");
        Paragraph step3 = new Paragraph("3. Öffne die App von deinem Home-Bildschirm aus");
        step3.addClassName("step");

        Html html = new Html("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube-nocookie.com/embed/AL_77M46fwk\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>");
        html.getElement().getStyle().set("width", "100%");
        main.add(step1, step2, step3, html);
        mainLayout.add(main);
    }

    private void buildChorome() {

        Paragraph step1 = new Paragraph("1. Klicke auf den Google Play Store Button unten.");
        step1.addClassName("step");
        Paragraph step2 = new Paragraph("2. Installiere die App");
        step2.addClassName("step");

        Html html = new Html("<a href='https://play.google.com/store/apps/details?id=de.heallife.app.twa&pcampaignid=pcampaignidMKT-Other-global-all-co-prtnr-py-PartBadge-Mar2515-1'><img alt='Get it on Google Play' src='https://play.google.com/intl/en_us/badges/static/images/badges/en_badge_web_generic.png'/></a>");

        main.add(step1, step2, html);
        mainLayout.add(horizontalLayout, main);
    }
}
