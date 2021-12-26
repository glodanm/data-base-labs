package com.database.iot.controller.impl;

import com.database.iot.model.dao.impl.AbstractGenericDaoImpl;
import com.database.iot.model.dao.impl.ClientWithTrainerDaoImpl;
import com.database.iot.model.entities.ClientWithTrainer;

public class ClientWithTrainerController extends AbstractGenericControllerImpl<ClientWithTrainer> {
    private final ClientWithTrainerDaoImpl clientWithTrainerDao = new ClientWithTrainerDaoImpl();

    @Override
    public AbstractGenericDaoImpl<ClientWithTrainer> getDao(){
        return clientWithTrainerDao;
    }
}