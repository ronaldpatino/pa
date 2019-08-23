package com.rpg.pa.backEnd;

import com.rpg.pa.pojo.Banco;
import com.rpg.pa.service.BancoService;
import com.vaadin.flow.data.provider.ListDataProvider;



public class BancoDataProvider extends ListDataProvider<Banco> {

    private String filterText = "";
    private BancoService bancoService  = new BancoService();

    public BancoDataProvider() {
        super(DataService.get().getAllBancos());
    }
}
