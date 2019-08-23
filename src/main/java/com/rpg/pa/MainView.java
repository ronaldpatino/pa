package com.rpg.pa;
import com.rpg.pa.views.BancoCrudView;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

/**
 * The main view contains a button and a click listener.
 */

@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
public class MainView extends VerticalLayout {

    public MainView() {


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
