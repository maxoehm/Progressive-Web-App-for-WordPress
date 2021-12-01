package de.heallife.app.views.profile;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.data.binder.ValidationException;
import de.heallife.app.data.QehrgUser;
import de.heallife.app.data.entity.QehrgUsermeta;
import de.heallife.app.data.entity.SamplePerson;
import de.heallife.app.data.service.QehrgUserService;
import de.heallife.app.data.service.SamplePersonService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.datepicker.DatePicker;
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
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.checkbox.Checkbox;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.util.Optional;

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
    private Binder<QehrgUsermeta> binderFirstName = new Binder(QehrgUsermeta.class);
    private Binder<QehrgUsermeta> binderLastName = new Binder(QehrgUsermeta.class);
    private Binder<QehrgUsermeta> binderAdress = new Binder(QehrgUsermeta.class);
    private Binder<QehrgUsermeta> binderCity = new Binder(QehrgUsermeta.class);
    private Binder<QehrgUsermeta> binderZip = new Binder(QehrgUsermeta.class);

    @Inject
    public ProfileView(AuthenticatedUser authenticatedUser, QehrgUserService service) {
        this.authenticatedUser = authenticatedUser;
        this.service = service;

        addClassName("profile-view");

        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        var authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        QehrgUser current = service.findAuth(authentication);

        var usermeta = service.getProfileValues(Long.valueOf(current.getId()));

        binderUser.readBean(current);

        firstName.setValue(usermeta.get(0).getMetaValue());
        binderFirstName.forField(firstName).bind("metaValue");

        lastName.setValue(usermeta.get(1).getMetaValue());
        binderFirstName.forField(lastName).bind("metaValue");

        email.setValue(current.getUserEmail());
        binderUser.forField(email).bind("userEmail");

        addressOne.setValue(usermeta.get(2).getMetaValue());
        binderAdress.forField(addressOne).bind("metaValue");

        addressCity.setValue(usermeta.get(3).getMetaValue());
        binderCity.forField(addressCity).bind("metaValue");

        addressZip.setValue(usermeta.get(4).getMetaValue());
        binderZip.forField(addressZip).bind("metaValue");

        cancel.addClickListener(event -> {
            UI.getCurrent().getPage().setLocation("https://heallife.de/protected-parent/account-page/?action=subscriptions");
                });

        save.addClickListener(e -> {
            try {

                binderFirstName.writeBean(usermeta.get(0));
                binderLastName.writeBean(usermeta.get(1));
                binderAdress.writeBean(usermeta.get(2));
                binderCity.writeBean(usermeta.get(3));
                binderZip.writeBean(usermeta.get(4));


                binderUser.writeBean(current);
                Notification notify = new Notification("Erfolgreich gespeichert");

                notify.setDuration(1500);
                notify.setPosition(Notification.Position.TOP_CENTER);
                notify.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
                notify.open();

            } catch (ValidationException ex) {
                ex.printStackTrace();
            }

            service.updateEntity(current);

            for (var bean : usermeta) {
                service.saveMeta(bean);
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
