package com.database.iot.controller.impl;

import com.database.iot.model.dao.impl.AbstractGenericDaoImpl;
import com.database.iot.model.dao.impl.ClientDaoImpl;
import com.database.iot.model.entities.Client;

public class ClientController extends AbstractGenericControllerImpl<Client> {
    private final ClientDaoImpl clientDao = new ClientDaoImpl();

    @Override
    public AbstractGenericDaoImpl<Client> getDao(){
        return clientDao;
    }
}