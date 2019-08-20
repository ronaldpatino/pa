package com.rpg.pa.views;

import com.rpg.pa.MainView;
import com.rpg.pa.pojo.Banco;
import com.rpg.pa.service.BancoService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BancoForm extends FormLayout {

    private static final Logger LOGGER = Logger.getLogger(BancoForm.class.getName());

    private TextField nombre = new TextField("Nombre");
    private Button  guardar = new Button("Guardar");
    private Button cancelar = new Button("Cancelar");
    private Binder<Banco> binder = new Binder<>(Banco.class);;
    private MainView mainView;
    private BancoService service = new BancoService();
    private Banco banco = new Banco();

    public BancoForm(MainView mainView) {
        LOGGER.log(Level.INFO,"INCIAMOS OBJETO FORM");
        binder.bindInstanceFields( this );
        binder.readBean(new Banco());
        this.mainView = mainView;
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(guardar, cancelar);
        guardar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(nombre, horizontalLayout);
        guardar.addClickListener(event -> save() );
    }

    private void save(){
        //Banco banco = this.binder.getBean();

        try {
            Banco savedBanco = new Banco();
            binder.writeBean(savedBanco);
            if (service.save( savedBanco ) != null){
                Notification notification = new Notification(
                        "Objeto Creado " + savedBanco.getNombre(), 3000,
                        Notification.Position.TOP_END);
                notification.open();

            }
            binder.readBean(new Banco());
        } catch (ValidationException e) {
            e.printStackTrace();
        }

        //mainView.updateList();
        //setBanco( null );
    }


}
