package com.github.devshiro.openfleet.service.ui.view;

import com.github.devshiro.openfleet.corda.schema.entity.ExampleEntity;
import com.github.devshiro.openfleet.service.ui.repository.ExampleRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.List;

public class AboutView extends VerticalLayout {

    private List<ExampleEntity> entities;

    public AboutView(ExampleRepository repository) {
        entities = repository.findAll();
        Grid<ExampleEntity> grid = new Grid<>(ExampleEntity.class);
        grid.setItems(entities);
        Button btn = new Button("Refresh", VaadinIcon.REFRESH.create(), event -> {
            entities = repository.findAll();
            grid.setItems(entities);
            grid.recalculateColumnWidths();
        });
        add(grid, btn);
        setSizeFull();
    }
}
