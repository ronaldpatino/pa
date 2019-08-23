package com.rpg.pa.views;

import com.rpg.pa.pojo.Banco;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;


public class BancoForm extends Div {

    private VerticalLayout content;
    private TextField nombre;
    private Binder binder;
    private Banco banco;

    public BancoForm() {
        content = new VerticalLayout();
        content.setSizeUndefined();
        add(content);

        nombre = new TextField("Nombre");
        content.add(nombre);

        binder = new Binder<>(Banco.class);

    }
}
