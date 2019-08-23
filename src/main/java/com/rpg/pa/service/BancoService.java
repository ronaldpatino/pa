package com.rpg.pa.service;

import com.rpg.pa.pojo.Banco;
import com.vaadin.flow.component.crud.CrudFilter;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.data.provider.AbstractBackEndDataProvider;
import com.vaadin.flow.data.provider.Query;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class BancoService {

    private static final Logger LOGGER = Logger.getLogger(BancoService.class.getName());
    private List<Banco> bancos = new LinkedList<>();

    public BancoService() {
        for(int i=0; i<10; i++){
            bancos.add(new Banco("banco numero " + i));
        }
    }

    public Banco save(Banco entry) {

        if (bancos.contains(entry)){
            bancos.remove(entry);
            bancos.add(entry);
        }
        else {
            bancos.add(entry);
        }

        LOGGER.log(Level.INFO,"Guardamos Banco  " + entry);
        return entry;
    }

    public void delete(Banco entry) {
        LOGGER.log(Level.INFO,"Borramos Banco  " + entry);
        bancos.remove(entry);
    }

    public List<Banco> findAll() {
        LOGGER.log(Level.INFO,"Bancos: " + bancos.size() );
        return bancos;
    }


}
