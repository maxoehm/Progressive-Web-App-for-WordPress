package de.heallife.app;

import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Inline;
import com.vaadin.flow.component.page.TargetElement;
import com.vaadin.flow.server.AppShellSettings;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import de.heallife.app.security.AuthenticatedUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.vaadin.artur.helpers.LaunchUtil;

import javax.inject.Inject;

/**
 * The entry point of the Spring Boot application.
 *
 * <p>Use the @PWA annotation make the application installable on phones, tablets and some desktop
 * browsers.
 */
@SpringBootApplication
@Theme(value = "heallifeapp")
@PWA(
    name = "HealLife",
    shortName = "HealLife",
    offlineResources = {
      "images/logo.png",
      "images/favicon.ico",
      "images/categories/",
      "images/categories/cactus.jpg",
      "images/categories/landscape.jpg",
      "images/categories/waterfall.jpg",
      "images/categories/ship.jpg",
      "images/categories/nightsky3.png",
      "images/categories/street.jpg",
      "images/categories/woman.jpg",
      "images/categories/day.jpg",
      "images/categories/sun.jpg",
      "images/categories/man.jpg",
      "images/categories/sununder.png",
      "images/categories/deer.jpg",
      "images/categories/nightsky.png",
      "images/categories/water.jpg",
      "images/categories/nightsky1.png",
      "images/categories/sunset.jpg",
      "images/categories/heallifelogo.svg",
      "/images/events/gw.jpg",
      "/views/home/post.css",
      "/themes/heallifeapp/views/homeView.css",
      "/themes/heallifeapp/views/heallife-iconset.js",
      "/themes/heallifeapp/main-layout.css",
      "/themes/heallifeapp/styles.css",
      "/images/events/cupofnothing.jpg",
      "/images/events/martin-adams-MpTdvXlAsVE-unsplash.jpg",
      "/images/events/scott-webb-2X6nZA0jmvU-unsplash.jpg",
      "/images/events/gw.jpg",
      "/images/events/cupofnothing.jpg"
    },
    iconPath = "images/logo_white.png",
    backgroundColor = "#ffffff",
    manifestPath = "manifest.json")
@NpmPackage(value = "line-awesome", version = "1.3.0")
public class Application extends SpringBootServletInitializer implements AppShellConfigurator {

  public static void main(String[] args) {
    LaunchUtil.launchBrowserInDevelopmentMode(SpringApplication.run(Application.class, args));
  }

  private AuthenticatedUser authenticatedUser;

  @Inject
  public Application(AuthenticatedUser authenticatedUser) {
    this.authenticatedUser = authenticatedUser;
  }

  @Override
  public void configurePage(AppShellSettings settings) {

    if (!authenticatedUser.get().isEmpty()) {
      settings.addInlineWithContents(
          TargetElement.HEAD,
          Inline.Position.APPEND,
          "<!-- Global site tag (gtag.js) - Google Analytics -->\n"
              + "<script async"
              + " src=\"https://www.googletagmanager.com/gtag/js?id=G-QDPCWFWSHM\"></script>\n"
              + "<script>\n"
              + "  window.dataLayer = window.dataLayer || [];\n"
              + "  function gtag(){dataLayer.push(arguments);}\n"
              + "  gtag('js', new Date());\n"
              + "\n"
              + "  gtag('config', 'G-QDPCWFWSHM');\n"
              + "</script><meta name=\"sentry-trace\" content=\"{{ span.toSentryTrace() }}\" />\n",
          Inline.Wrapping.AUTOMATIC);
    }

    settings.addInlineWithContents(
        TargetElement.HEAD,
        Inline.Position.APPEND,
        "<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\"> \n"
            + "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin> \n"
            + "<link href=\"https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;"
            + "0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,500&display=swap\" rel=\"stylesheet\">",
        Inline.Wrapping.AUTOMATIC);
  }

}
