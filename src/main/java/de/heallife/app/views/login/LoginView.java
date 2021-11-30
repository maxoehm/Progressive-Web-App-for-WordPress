package de.heallife.app.views.login;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import java.util.Base64;
import java.nio.charset.StandardCharsets;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.router.RouteAlias;
import elemental.json.Json;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.component.html.Label;
import org.springframework.web.util.UriUtils;
import java.io.ByteArrayOutputStream;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.html.Image;

@PageTitle("Login")
@Route(value = "login")
public class LoginView extends LoginOverlay {

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
