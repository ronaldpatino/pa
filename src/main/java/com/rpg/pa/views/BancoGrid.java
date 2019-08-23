package com.rpg.pa.views;

import com.rpg.pa.pojo.Banco;
import com.vaadin.flow.component.grid.Grid;

public class BancoGrid extends Grid<Banco> {

    public BancoGrid() {
        addColumn(Banco::getNombre)
                .setHeader("Nombre")
                .setFlexGrow(20)
                .setSortable(true);
    }

    public Banco getSelectedRow() {
        return asSingleSelect().getValue();
    }
}
