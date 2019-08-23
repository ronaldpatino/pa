package com.rpg.pa.backEnd;

import com.rpg.pa.pojo.Banco;
import com.rpg.pa.service.BancoService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MockDataService extends DataService {

    private static MockDataService INSTANCE;
    private BancoService bancoService;
    private List<Banco> bancos;

    public MockDataService() {
        bancoService = new BancoService();
        bancos = bancoService.findAll();
    }

    @Override
    public synchronized Collection<Banco> getAllBancos() {
        return Collections.unmodifiableList(bancos);
    }

    public synchronized static DataService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MockDataService();
        }
        return INSTANCE;
    }

}
