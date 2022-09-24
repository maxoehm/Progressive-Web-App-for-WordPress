package de.heallife.app.views.home;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouteConfiguration;
import de.heallife.app.builders.PostView;
import de.heallife.app.data.entity.Post;
import de.heallife.app.data.service.communication.NewPostNotificationService;
import de.heallife.app.views.MainLayout;
import de.heallife.app.views.categories.CategoryView;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * A Designer generated component for the home-view template.
 *
 * <p>Designer will add and remove fields with @Id mappings but does not overwrite or otherwise
 * change this file.
 */
@Tag("home-view")
@Route(value = "home", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@JsModule("./views/home/home-view.ts")
@CssImport("./themes/heallifeapp/views/homeView.css")
@CssImport(value = "./themes/heallifeapp/views/PopupDialog.css", themeFor = "vaadin-dialog-overlay")
@PermitAll
public class HomeView extends LitTemplate {

  @Id("h1")
  private H1 h1;

  @Id("c1")
  private VerticalLayout c1;

  @Id("vaadinVerticalLayout")
  private VerticalLayout vaadinVerticalLayout;

  @Id("vaadinVerticalLayout1")
  private VerticalLayout vaadinVerticalLayout1;

  @Id("vaadinVerticalLayout2")
  private VerticalLayout vaadinVerticalLayout2;

  @Id("vaadinVerticalLayout3")
  private VerticalLayout vaadinVerticalLayout3;

  @Id("vaadinVerticalLayout4")
  private VerticalLayout vaadinVerticalLayout4;

  @Id("vaadinVerticalLayout5")
  private VerticalLayout vaadinVerticalLayout5;

  @Id("vaadinVerticalLayout6")
  private VerticalLayout vaadinVerticalLayout6;

  @Id("vaadinVerticalLayout7")
  private VerticalLayout vaadinVerticalLayout7;

  @Id("vaadinVerticalLayout8")
  private VerticalLayout vaadinVerticalLayout8;

  @Id("search-input")
  private TextField searchInput;

  @Id("search-icon")
  private Icon searchIcon;

  @Id("dialog1")
  private Dialog dialog;

  private Logger logger = LoggerFactory.getLogger(getClass());

  private NewPostNotificationService newPostNotificationService;

  @Inject
  public HomeView(NewPostNotificationService newPostNotificationService) {
    this.newPostNotificationService = newPostNotificationService;

    searchInput.addKeyPressListener(
        Key.ENTER,
        e -> {
          String route =
              RouteConfiguration.forSessionScope()
                  .getUrl(SearchResultView.class, searchInput.getValue());
          searchIcon.getUI().ifPresent(ui -> ui.navigate(route));
        });

    searchIcon.addClickListener(
        e -> {
          String route =
              RouteConfiguration.forSessionScope()
                  .getUrl(SearchResultView.class, searchInput.getValue());
          searchIcon.getUI().ifPresent(ui -> ui.navigate(route));
        });

    h1.setText("Entdecken");

    c1.addClickListener(
        event -> {
          String route =
              RouteConfiguration.forSessionScope().getUrl(CategoryView.class, "Allgemeinwissen");
          c1.getUI().ifPresent(ui -> ui.navigate(route));
        });

    vaadinVerticalLayout.addClickListener(
        event -> {
          String route =
              RouteConfiguration.forSessionScope().getUrl(CategoryView.class, "Gezielte_Bewegung");
          vaadinVerticalLayout.getUI().ifPresent(ui -> ui.navigate(route));
        });

    vaadinVerticalLayout1.addClickListener(
        event -> {
          String route =
              RouteConfiguration.forSessionScope().getUrl(CategoryView.class, "Freizeit");
          vaadinVerticalLayout1.getUI().ifPresent(ui -> ui.navigate(route));
        });

    vaadinVerticalLayout2.addClickListener(
        event -> {
          String route =
              RouteConfiguration.forSessionScope().getUrl(CategoryView.class, "Lifestyle");
          vaadinVerticalLayout2.getUI().ifPresent(ui -> ui.navigate(route));
        });

    vaadinVerticalLayout3.addClickListener(
        event -> {
          String route =
              RouteConfiguration.forSessionScope()
                  .getUrl(CategoryView.class, "Physische_Gesundheit");
          vaadinVerticalLayout3.getUI().ifPresent(ui -> ui.navigate(route));
        });

    vaadinVerticalLayout4.addClickListener(
        event -> {
          String route =
              RouteConfiguration.forSessionScope()
                  .getUrl(CategoryView.class, "Seelische_und_mentale_Gesundheit");
          vaadinVerticalLayout4.getUI().ifPresent(ui -> ui.navigate(route));
        });

    vaadinVerticalLayout5.addClickListener(
        event -> {
          String route = RouteConfiguration.forSessionScope().getUrl(CategoryView.class, "Podcast");
          vaadinVerticalLayout5.getUI().ifPresent(ui -> ui.navigate(route));
        });

    vaadinVerticalLayout6.addClickListener(
        event -> {
          String route =
              RouteConfiguration.forSessionScope().getUrl(CategoryView.class, "Ernährung");
          vaadinVerticalLayout6.getUI().ifPresent(ui -> ui.navigate(route));
        });

    vaadinVerticalLayout7.addClickListener(
        event -> {
          String route = RouteConfiguration.forSessionScope().getUrl(CategoryView.class, "Yoga");
          vaadinVerticalLayout7.getUI().ifPresent(ui -> ui.navigate(route));
        });

    vaadinVerticalLayout8.addClickListener(
        event -> {
          String route =
              RouteConfiguration.forSessionScope().getUrl(CategoryView.class, "Spendenaktion");
          vaadinVerticalLayout8.getUI().ifPresent(ui -> ui.navigate(route));
        });

    /*
            String route = RouteConfiguration.forSessionScope()
                    .getUrl(PostView.class, postList.get(i+1).getId());

            c1.addClickListener(event -> {
                c1.getUI().ifPresent(ui -> ui.navigate(route));
            });
    */

    newPostNotificationService.init(
        SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());

    if (newPostNotificationService.isNewPostAvailable()) {
      buildDialogNewPost();
    }
  }

  private void buildDialogNewPost() {
    Optional<Post> latestPost = newPostNotificationService.getPost();

    if (latestPost.isPresent()) {

      H2 h2 = new H2("Es gibt neue Inhalte.");
      Paragraph body = new Paragraph("Hier kannst du sie dir ansehen.");
      VerticalLayout vertical = new VerticalLayout();

      VerticalLayout blogPostMin = new VerticalLayout();

      blogPostMin.setId("blogPostMin");
      blogPostMin
          .getStyle()
          .set("background-image", "url(" + newPostNotificationService.getImageUrl() + ")");
      blogPostMin.getStyle().set("background-size", "cover");
      H3 titleImage = new H3(latestPost.get().getPostTitle());
      titleImage.setId("titleImage");
      titleImage.getElement().setAttribute("lang", "de");
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

      LocalDateTime ldt =
          LocalDateTime.ofInstant(latestPost.get().getPostDate(), ZoneId.systemDefault());
      DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
      Paragraph meta = new Paragraph(ldt.format(format));
      meta.setId("meta");

      blogPostMin.add(titleImage, meta);
      vertical.setAlignItems(FlexComponent.Alignment.CENTER);

      Button dismiss = new Button("Nicht jetzt", event -> dialog.close());
      Button viewPost =
          new Button(
              "Jetzt Anschauen",
              event -> {
                dialog.close();
                String route =
                    RouteConfiguration.forSessionScope()
                        .getUrl(PostView.class, latestPost.get().getId());
                dialog.getUI().ifPresent(ui -> ui.navigate(route));
              });

      viewPost.setThemeName("primary");
      viewPost.setId("viewPostBtn");
      dismiss.setId("dismissBtn");
      h2.setId("h1Notify");
      body.setId("bodyNotify");

      vertical.add(h2, body, blogPostMin, new HorizontalLayout(dismiss, viewPost));
      dialog.add(vertical);
      dialog.open();
    }
  }
}
