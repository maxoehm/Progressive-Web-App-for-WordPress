package de.heallife.app.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.router.PageTitle;
import de.heallife.app.views.events.EventsView;
import de.heallife.app.views.home.HomeView;
import de.heallife.app.views.profile.ProfileView;
import de.heallife.app.views.blog.BlogView;
import de.heallife.app.security.AuthenticatedUser;
import com.vaadin.flow.server.auth.AccessAnnotationChecker;

/**
 * The main view is a top-level placeholder for other views.
 */
@PageTitle("Main")
@JsModule("./themes/heallifeapp/views/heallife-iconset.js")
@CssImport(value = "./themes/heallifeapp/views/app-layout-style.css", themeFor = "vaadin-app-layout")
public class MainLayout extends AppLayout {

    public static class MenuItemInfo {

        private String text;
        private String iconClass;
        private Class<? extends Component> view;

        public MenuItemInfo(String text, String iconClass, Class<? extends Component> view) {
            this.text = text;
            this.iconClass = iconClass;
            this.view = view;
        }

        public String getText() {
            return text;
        }

        public String getIconClass() {
            return iconClass;
        }

        public Class<? extends Component> getView() {
            return view;
        }

    }

    private H1 viewTitle;
    private Tab homeTab;

    private AuthenticatedUser authenticatedUser;
    private AccessAnnotationChecker accessChecker;

    public MainLayout(AuthenticatedUser authenticatedUser, AccessAnnotationChecker accessChecker) {
        this.authenticatedUser = authenticatedUser;
        this.accessChecker = accessChecker;

        viewTitle = new H1();

        Icon home = new Icon("heallife","home-alt");
        home.setSize("30px");
        Icon blog = new Icon("heallife","book-alt");
        blog.setSize("30px");
        Icon events = new Icon("heallife","swatchbook");
        events.setSize("30px");
        Icon subscribe = new Icon("heallife", "user-square");
        subscribe.setSize("30px");

        RouterLink homeRoute = new RouterLink(null, HomeView.class);
        homeRoute.add(home);
        homeTab = new Tab(homeRoute);

        RouterLink swatchbook = new RouterLink(null, EventsView.class);
        swatchbook.add(events);
        Tab swatchTab = new Tab(swatchbook);

        RouterLink headphones = new RouterLink(null, ProfileView.class);
        headphones.add(subscribe);
        Tab headTab = new Tab(headphones);

        RouterLink book = new RouterLink(null, BlogView.class);
        book.add(blog);
        Tab bookTab = new Tab(book);

        Tabs tabs = new Tabs(homeTab, swatchTab, bookTab, headTab);

        tabs.getStyle().set("color", "black");
        tabs.getStyle().set("height", "62px");
        tabs.addThemeVariants(TabsVariant.LUMO_EQUAL_WIDTH_TABS);

        tabs.addSelectedChangeListener(change -> {

            if (homeTab.isSelected()) {
                homeTab.getStyle().set("filter", "grayscale(0%)");
            } else {
                homeTab.getStyle().set("filter", "grayscale(100%)");
            }

            if (swatchTab.isSelected()) {
                swatchTab.getStyle().remove("filter");
            } else {
                swatchTab.getStyle().set("filter", "grayscale(100%)");
            }

            if (headTab.isSelected()) {
                headTab.getStyle().remove("filter");
            } else {
                headTab.getStyle().set("filter", "grayscale(100%)");
            }

            if (bookTab.isSelected()) {
                bookTab.getStyle().remove("filter");
            } else {
                bookTab.getStyle().set("filter", "grayscale(100%)");
            }


        });

        addToNavbar(true, tabs);
    }



    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
