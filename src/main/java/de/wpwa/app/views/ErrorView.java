package de.wpwa.app.views;

import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route(value = "error")
@AnonymousAllowed
public class ErrorView extends FlexLayout {

  public ErrorView() {}
}
