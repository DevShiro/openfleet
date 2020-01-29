package com.github.devshiro.openfleet.service.ui.view;

import com.github.devshiro.openfleet.service.ui.repository.ExampleRepository;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Route("")
@Viewport("width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes, viewport-fit=cover")
@PWA(name = "Openfleet Dashboard", shortName = "Openfleet")
public class MainView extends AppLayout {

    private List<Pair<Tab, Component>> tabToComponent = new ArrayList<>();

    public MainView(@Autowired ExampleRepository repository) {

        Tab home = new Tab("Home");
        tabToComponent.add(Pair.of(home, new ExampleView()));

        Tab about = new Tab("About");
        tabToComponent.add(Pair.of(about, new AboutView(repository)));

        addToNavbar(new DrawerToggle());
        Tabs tabs = new Tabs();
        tabToComponent.stream()
                .map(Pair::getKey)
                .forEach(tabs::add);
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        tabs.addSelectedChangeListener(event -> {
            Tab selectedTab = event.getSelectedTab();
            Optional<Component> content = tabToComponent.stream().filter(pair -> pair.getKey().equals(selectedTab)).map(Pair::getValue).findFirst();
            if (content.isPresent()) {
                setContent(content.get());
            } else {
                Notification.show("Component Missing");
            }
        });
        addToDrawer(tabs);
    }
}
