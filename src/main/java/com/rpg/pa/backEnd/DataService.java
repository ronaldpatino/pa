package com.rpg.pa.backEnd;

import com.rpg.pa.pojo.Banco;

import java.io.Serializable;
import java.util.Collection;

public abstract class DataService implements Serializable {

    public abstract Collection<Banco> getAllBancos();

    public static DataService get() {
        return MockDataService.getInstance();
    }
}
