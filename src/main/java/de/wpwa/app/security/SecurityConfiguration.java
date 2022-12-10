package de.wpwa.app.security;

import com.vaadin.flow.spring.security.VaadinWebSecurityConfigurerAdapter;
import de.wpwa.app.views.login.LoginView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends VaadinWebSecurityConfigurerAdapter {

  public static final String LOGOUT_URL = "/";

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Autowired private UserDetailsService userDetailsService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.rememberMe().alwaysRemember(true).userDetailsService(userDetailsService);

    super.configure(http);
    setLoginView(http, LoginView.class, LOGOUT_URL);
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/images/*.png");
    web.ignoring().antMatchers("/images/*.jpg");
    web.ignoring().antMatchers("/images/*.webp");
    web.ignoring().antMatchers("/images/***");
    web.ignoring().antMatchers("/images/categories/*.png");
    web.ignoring().antMatchers("/images/categories/*.jpg");
    web.ignoring().antMatchers("/images/events/*.*");
    web.ignoring().antMatchers("/images/events/***");
    web.ignoring().antMatchers("manifest.json");
    web.ignoring().antMatchers("/manifest.json");

    super.configure(web);
  }
}
