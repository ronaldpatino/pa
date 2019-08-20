package com.rpg.pa.views;

import com.rpg.pa.MainView;
import com.rpg.pa.pojo.Banco;
import com.vaadin.flow.component.grid.Grid;

import java.util.LinkedList;
import java.util.List;

public class BancoGrid {

    private List<Banco> bancos = new LinkedList<>();
    private Grid<Banco> bancoGrid = new Grid<>(Banco.class);
    private MainView mainView = new MainView();
    public BancoGrid(MainView mainView) {
        this.mainView = mainView;
    }

    public List<Banco> getBancos() {
        return bancos;
    }

    public void setBancos(List<Banco> bancos) {
        this.bancos = bancos;
    }

    public Grid<Banco> getBancoGrid() {
        return bancoGrid;
    }

    public void setBancoGrid(Grid<Banco> bancoGrid) {
        this.bancoGrid = bancoGrid;
    }
}
