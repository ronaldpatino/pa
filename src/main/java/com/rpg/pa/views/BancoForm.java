package com.rpg.pa.views;

import com.rpg.pa.MainLayout;
import com.rpg.pa.pojo.Banco;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

import java.util.logging.Level;
import java.util.logging.Logger;

@Route(value="bancos/form", layout = MainLayout.class)
public class BancoForm extends Div {

    private static final Logger LOGGER = Logger.getLogger(BancoForm.class.getName());

    private VerticalLayout content;
    private TextField nombre;
    private Binder binder;
    private Banco banco;

    public BancoForm() {
        LOGGER.log(Level.INFO,"INCIAMOS OBJETO FORM");
        content = new VerticalLayout();
        content.setSizeUndefined();
        add(content);

        nombre = new TextField("Nombre");
        content.add(nombre);
        binder = new Binder<>(Banco.class);
        binder.bindInstanceFields(this);
        binder.readBean(new Banco());

    }
}
