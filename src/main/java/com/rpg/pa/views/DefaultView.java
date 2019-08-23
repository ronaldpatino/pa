package com.rpg.pa.views;

import com.rpg.pa.MainLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "home", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class DefaultView extends VerticalLayout {
    private Label label;

    public DefaultView() {
        label = new Label("Home");
        add(label);
    }
}
