package com.rpg.pa.views;

import com.rpg.pa.backEnd.BancoDataProvider;
import com.rpg.pa.service.BancoService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class BancoCrudView extends HorizontalLayout {

    public static final String VIEW_NAME = "Inventory";
    private BancoGrid bancoGrid;
    private TextField bancoFilter;
    private Button bancoNuevoButton;
    private BancoDataProvider bancoDataProvider = new BancoDataProvider();

    public BancoCrudView() {
        setSizeFull();
        HorizontalLayout topLayout = createTopBar();
        bancoGrid = new BancoGrid();
        bancoGrid.setDataProvider(bancoDataProvider);

        VerticalLayout barAndGridLayout = new VerticalLayout();
        barAndGridLayout.add(topLayout);
        barAndGridLayout.add(bancoGrid);
        barAndGridLayout.setFlexGrow(1, bancoGrid);
        barAndGridLayout.setFlexGrow(0, topLayout);
        barAndGridLayout.setSizeFull();
        barAndGridLayout.expand(bancoGrid);
        add(barAndGridLayout);
    }


    public HorizontalLayout createTopBar(){
        bancoFilter = new TextField();
        bancoFilter.setPlaceholder("Buscar");
        bancoNuevoButton = new Button("Nuevo");
        bancoNuevoButton.setIcon(VaadinIcon.PLUS_CIRCLE.create());

        HorizontalLayout topLayout = new HorizontalLayout();
        topLayout.setWidth("100%");
        topLayout.add(bancoFilter);
        topLayout.add(bancoNuevoButton);
        topLayout.setVerticalComponentAlignment(Alignment.START, bancoFilter);
        topLayout.expand(bancoFilter);

        return topLayout;
    }
}
