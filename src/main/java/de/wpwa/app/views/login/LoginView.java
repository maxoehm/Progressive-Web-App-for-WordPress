package de.wpwa.app.views.login;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.router.*;

@PageTitle("Login")
@Route(value = "login")
public class LoginView extends LoginOverlay implements BeforeEnterObserver {

  private LoginI18n i18n = LoginI18n.createDefault();

  public LoginView() {
    setAction("login");

    i18n.setHeader(new LoginI18n.Header());
    i18n.getHeader().setTitle("HealLife App");
    i18n.getHeader().setDescription("Melde dich mit deinem Nutzernamen und Passwort an");
    i18n.setAdditionalInformation(null);

    setI18n(i18n);
    setForgotPasswordButtonVisible(false);
    setOpened(true);
  }

  @Override
  public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
    Location location = beforeEnterEvent.getLocation();
    QueryParameters queryParameters = location.getQueryParameters();

    if (queryParameters.getParameters().containsKey("error")) {
      Notification notification = new Notification();

      Paragraph paragraph =
          new Paragraph(
              "Login fehlgeschlagen, bitte überprüfe deine Anmeldedaten und stelle sicher, dass"
                  + " dein Abo aktiv ist. Du kannst dein Abo auf heallife.de/login einsehen. Klicke"
                  + " dafür einfach auf den Button.\"");

      Button button =
          new Button(
              "Konto einsehen",
              event -> {
                notification.close();
                UI.getCurrent()
                    .getPage()
                    .setLocation(
                        "https://heallife.de/protected-parent/account-page/?action=subscriptions");
                //
                // UI.getCurrent().getPage().executeJs("window.open(\"https://heallife.de/protected-parent/account-page/\", '_blank').focus();");
              });

      notification.add(paragraph, button);
      notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
      notification.setDuration(10000);
      notification.open();
    }
  }
}
