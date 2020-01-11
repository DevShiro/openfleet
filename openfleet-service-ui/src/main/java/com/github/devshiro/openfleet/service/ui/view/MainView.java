package com.github.devshiro.openfleet.service.ui.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

@Route("")
@PWA(name = "Openfleet dashboard", shortName = "Dashboard")
public class MainView extends VerticalLayout {

    public MainView() {
        Button button = new Button("Press me", VaadinIcon.QUESTION.create(), event -> {
            Notification.show("Button clicked");
        });
        add(button);
        setSizeFull();
    }
}
