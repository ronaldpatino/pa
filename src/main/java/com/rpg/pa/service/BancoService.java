package com.rpg.pa.service;

import com.rpg.pa.pojo.Banco;
import com.vaadin.flow.component.crud.CrudFilter;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.data.provider.AbstractBackEndDataProvider;
import com.vaadin.flow.data.provider.Query;

import java.util.Collection;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class BancoService extends AbstractBackEndDataProvider<Banco, CrudFilter> {

    private static final Logger LOGGER = Logger.getLogger(BancoService.class.getName());
    private Collection<Banco> bancos = new LinkedList<>();

    public BancoService() {
    }

    public Stream<Banco> getStream(){
        return bancos.stream();
    }

    @Override
    protected Stream<Banco> fetchFromBackEnd(Query<Banco, CrudFilter> query) {
        return bancos.stream();
    }

    @Override
    protected int sizeInBackEnd(Query<Banco, CrudFilter> query) {
        return bancos.size();
    }

    public Banco save(Banco entry){

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

    public void delete(Banco entry){
        LOGGER.log(Level.INFO,"Borramos Banco  " + entry);
        bancos.remove(entry);
    }

    public Collection<Banco> findAll(){
        LOGGER.log(Level.INFO,"Bancos: " + bancos.size() );
        return bancos;
    }


}
