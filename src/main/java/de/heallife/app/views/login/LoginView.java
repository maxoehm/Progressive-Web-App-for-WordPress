package de.heallife.app.views.login;

import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Login")
@Route(value = "login")
public class LoginView extends LoginOverlay{

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
}
