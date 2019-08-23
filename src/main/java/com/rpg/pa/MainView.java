package com.rpg.pa;


import com.rpg.pa.pojo.Banco;
import com.rpg.pa.service.BancoService;
import com.rpg.pa.views.BancoCrudView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.crud.BinderCrudEditor;
import com.vaadin.flow.component.crud.CrudEditor;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.vaadin.crudui.crud.CrudListener;
import org.vaadin.crudui.crud.impl.GridCrud;

import java.awt.*;
import java.util.Collection;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
public class MainView extends VerticalLayout {

    public MainView() {

        BancoCrudView bancoCrudView = new BancoCrudView();

        add(bancoCrudView);

        /*
        setSizeFull();
        Button nuevoButton = new Button("Nuevo", new Icon(VaadinIcon.PLUS));
        nuevoButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSizeFull();
        horizontalLayout.setWidth("100%");
        horizontalLayout.setVerticalComponentAlignment(Alignment.END, nuevoButton);

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSizeFull();
        BancoService bancoService = new BancoService();
        Grid<Banco> grid = new Grid<>();
        grid.setItems(bancoService.findAll());
        grid.addColumn(Banco::getNombre).setHeader("Nombre");
        verticalLayout.add(grid);

        horizontalLayout.add(nuevoButton);
        add(horizontalLayout);
        add(verticalLayout);

         */
    }

}
