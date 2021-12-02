package de.heallife.app;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.vaadin.artur.helpers.LaunchUtil;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.component.dependency.NpmPackage;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 *
 */
@SpringBootApplication
@Theme(value = "heallifeapp")
@PWA(
        name = "HealLife",
        shortName = "HealLife",
        offlineResources = {"images/logo.png", "images/favicon.ico", "images/categories/", "images/categories/cactus.jpg", "images/categories/landscape.jpg", "images/categories/waterfall.jpg", "images/categories/ship.jpg", "images/categories/nightsky3.png", "images/categories/street.jpg", "images/categories/woman.jpg", "images/categories/day.jpg", "images/categories/sun.jpg", "images/categories/man.jpg", "images/categories/sununder.png", "images/categories/deer.jpg", "images/categories/nightsky.png", "images/categories/water.jpg", "images/categories/nightsky1.png", "images/categories/sunset.jpg", "images/categories/heallifelogo.svg", "/images/events/gw.jpg", "/views/home/post.css", "/themes/heallifeapp/views/homeView.css", "/themes/heallifeapp/views/heallife-iconset.js", "/themes/heallifeapp/main-layout.css", "/themes/heallifeapp/styles.css", "/images/events/cupofnothing.jpg", "/images/events/martin-adams-MpTdvXlAsVE-unsplash.jpg", "/images/events/scott-webb-2X6nZA0jmvU-unsplash.jpg", "/images/events/gw.jpg", "/images/events/cupofnothing.jpg"},
        iconPath = "images/logo.png", backgroundColor = "#ffffff", themeColor = "#ffffff")
@NpmPackage(value = "line-awesome", version = "1.3.0")
public class Application extends SpringBootServletInitializer implements AppShellConfigurator {

    public static void main(String[] args) {
        LaunchUtil.launchBrowserInDevelopmentMode(SpringApplication.run(Application.class, args));
    }

}