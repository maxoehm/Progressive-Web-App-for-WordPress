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
@PermitAll
public class HomeView extends VerticalLayout {

    public HomeView() {
    //    setSpacing(false);

        VerticalLayout vt = buildCategories();
        add(vt);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

    private VerticalLayout buildCategories() {
        VerticalLayout vt = new VerticalLayout();

        HorizontalLayout ht = new HorizontalLayout();

        VerticalLayout containerA = new VerticalLayout();
        Image imgA = new Image("images/empty-plant.png", "");
        H4 h4A = new H4("Demotext A");
        containerA.add(imgA, h4A);
        VerticalLayout containerB = new VerticalLayout();
        Image imgB = new Image("images/empty-plant.png", "");
        H4 h4B = new H4("Demotext B");
        containerB.add(imgB, h4B);
        ht.add(containerA, containerB);

        HorizontalLayout ht2 = new HorizontalLayout();
        VerticalLayout containerC = new VerticalLayout();
        Image imgC = new Image("images/empty-plant.png", "");
        H4 h4C = new H4("Demotext C");
        containerC.add(imgC, h4C);
        VerticalLayout containerD = new VerticalLayout();
        Image imgD = new Image("images/empty-plant.png", "");
        H4 h4D = new H4("Demotext D");
        containerB.add(imgD, h4D);
        ht2.add(containerC, containerD);

        HorizontalLayout ht3 = new HorizontalLayout();
        VerticalLayout containerE = new VerticalLayout();
        Image imgE = new Image("images/empty-plant.png", "");
        H4 h4E = new H4("Demotext E");
        containerE.add(imgE, h4E);
        VerticalLayout containerF = new VerticalLayout();
        Image imgF = new Image("images/empty-plant.png", "");
        H4 h4F = new H4("Demotext F");
        containerF.add(imgF, h4F);
        ht3.add(containerE, containerF);

        HorizontalLayout ht4 = new HorizontalLayout();
        VerticalLayout containerG = new VerticalLayout();
        Image imgG = new Image("images/empty-plant.png", "");
        H4 h4G = new H4("Demotext G");
        containerG.add(imgG, h4G);
        VerticalLayout containerH = new VerticalLayout();
        Image imgH = new Image("images/empty-plant.png", "");
        H4 h4H = new H4("Demotext H");
        containerH.add(imgH, h4H);
        ht4.add(containerG, containerH);

        vt.add(ht, ht2, ht3, ht4);
        return vt;
    }

}
