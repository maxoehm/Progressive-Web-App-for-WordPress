package de.heallife.app.views.profile;

import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.data.binder.ValidationException;
import de.heallife.app.data.QehrgUser;
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


    private TextField firstName = new TextField("First name");
    private TextField lastName = new TextField("Last name");
    private EmailField email = new EmailField("Email address");
    private DatePicker dateOfBirth = new DatePicker("Birthday");
    private TextField occupation = new TextField("Occupation");

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");

    private Binder<QehrgUser> binder = new Binder(QehrgUser.class);

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


        binder.readBean(current);


        firstName.setValue(current.getUserNicename());

        binder.forField(lastName).bind("displayName");

        lastName.setValue(current.getDisplayName());
        email.setValue(current.getUserEmail());
        occupation.setValue(current.getUserLogin());

        save.addClickListener(e -> {
            try {
                binder.writeBean(current);
                Notification notify = new Notification("Erfolgreich gespeichert");
                notify.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
                notify.open();
            } catch (ValidationException ex) {
                ex.printStackTrace();
            }
            service.updateEntity(current);
        });
    }


    private Component createTitle() {
        return new H3("Personal information");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        email.setErrorMessage("Please enter a valid email address");
        formLayout.add(firstName, lastName, dateOfBirth, email, occupation);
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

    private static class PhoneNumberField extends CustomField<String> {
        private ComboBox<String> countryCode = new ComboBox<>();
        private TextField number = new TextField();

        public PhoneNumberField(String label) {
            setLabel(label);
            countryCode.setWidth("120px");
            countryCode.setPlaceholder("Country");
            countryCode.setPattern("\\+\\d*");
            countryCode.setPreventInvalidInput(true);
            countryCode.setItems("+354", "+91", "+62", "+98", "+964", "+353", "+44", "+972", "+39", "+225");
            countryCode.addCustomValueSetListener(e -> countryCode.setValue(e.getDetail()));
            number.setPattern("\\d*");
            number.setPreventInvalidInput(true);
            HorizontalLayout layout = new HorizontalLayout(countryCode, number);
            layout.setFlexGrow(1.0, number);
            add(layout);
        }

        @Override
        protected String generateModelValue() {
            if (countryCode.getValue() != null && number.getValue() != null) {
                String s = countryCode.getValue() + " " + number.getValue();
                return s;
            }
            return "";
        }

        @Override
        protected void setPresentationValue(String phoneNumber) {
            String[] parts = phoneNumber != null ? phoneNumber.split(" ", 2) : new String[0];
            if (parts.length == 1) {
                countryCode.clear();
                number.setValue(parts[0]);
            } else if (parts.length == 2) {
                countryCode.setValue(parts[0]);
                number.setValue(parts[1]);
            } else {
                countryCode.clear();
                number.clear();
            }
        }
    }

}
