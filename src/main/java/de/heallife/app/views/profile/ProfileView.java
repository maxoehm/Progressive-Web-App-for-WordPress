package de.heallife.app.views.profile;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.data.binder.ValidationException;
import de.heallife.app.data.QehrgUser;
import de.heallife.app.data.service.QehrgUserService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import de.heallife.app.security.AuthenticatedUser;
import de.heallife.app.views.MainLayout;
import javax.annotation.security.PermitAll;
import javax.inject.Inject;

import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.concurrent.atomic.AtomicBoolean;

@PageTitle("profile")
@Route(value = "profile", layout = MainLayout.class)
@PermitAll
@Uses(Icon.class)
public class ProfileView extends Div {

    private AuthenticatedUser authenticatedUser;
    private QehrgUserService service;


    private TextField firstName = new TextField("Vorname");
    private TextField lastName = new TextField("Nachname");
    private EmailField email = new EmailField("Email Adresse");
    private TextField addressOne = new TextField("Straßenname");
    private TextField addressCity = new TextField("Stadt");
    private TextField addressZip = new TextField("Zip");

    private Button cancel = new Button("Abonennt beenden");
    private Button save = new Button("Speichern");

    private Binder<QehrgUser> binderUser = new Binder(QehrgUser.class);

    @Inject
    public ProfileView(AuthenticatedUser authenticatedUser, QehrgUserService service) {
        this.authenticatedUser = authenticatedUser;
        this.service = service;

        addClassName("profile-view");

        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        var authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        var current = service.findAuth(authentication);

        var usermeta = service.getProfileValues(Long.valueOf(current.getId()));

        binderUser.readBean(current);

        firstName.setValue(usermeta.get(0).getMetaValue());

        lastName.setValue(usermeta.get(1).getMetaValue());

        email.setValue(current.getUserEmail());
        email.setReadOnly(true);

        AtomicBoolean hasNotBeenTriggered = new AtomicBoolean(true);

        email.getElement().addEventListener("mouseover", event -> {

            if (hasNotBeenTriggered.get()) {
                Notification notification = new Notification("Deine Email Adresse kannst du auf der Website (heallife.de) ändern.");
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                notification.setDuration(10000);

                notification.open();
                hasNotBeenTriggered.set(false);
            }

        });


        addressOne.setValue(usermeta.get(2).getMetaValue());

        addressCity.setValue(usermeta.get(3).getMetaValue());

        addressZip.setValue(usermeta.get(4).getMetaValue());

        cancel.addClickListener(event -> {
            UI.getCurrent().getPage().setLocation("https://heallife.de/protected-parent/account-page/?action=subscriptions");
                });

        save.addClickListener(e -> {
            try {

                usermeta.get(0).setMetaValue(firstName.getValue());
                usermeta.get(1).setMetaValue(lastName.getValue());
                usermeta.get(2).setMetaValue(addressOne.getValue());
                usermeta.get(3).setMetaValue(addressCity.getValue());
                usermeta.get(4).setMetaValue(addressZip.getValue());;

                binderUser.writeBean(current);
                service.updateEntity(current);

                for (var bean : usermeta) {
                    service.saveMeta(bean);
                }

                Notification notify = new Notification("Erfolgreich gespeichert");

                notify.setDuration(1500);
                notify.setPosition(Notification.Position.TOP_CENTER);
                notify.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
                notify.open();

            } catch (ValidationException ex) {
                ex.printStackTrace();
            }

        });
    }


    private Component createTitle() {
        return new H3("Informationen ändern");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        email.setErrorMessage("Das ist keine gültige Email Adresse!");
        formLayout.add(firstName, lastName, email, addressZip, addressOne, addressCity);

        formLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1),
                new FormLayout.ResponsiveStep("100px", 2)

        );

        formLayout.setColspan(addressCity,2);
        formLayout.setColspan(email, 2);

        return formLayout;
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save);
        buttonLayout.add(cancel);
        return buttonLayout;
    }

}
