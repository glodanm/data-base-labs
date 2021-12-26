package com.database.iot.controller.impl;

import com.database.iot.model.dao.impl.AbstractGenericDaoImpl;
import com.database.iot.model.dao.impl.FitnessMachineDaoImpl;
import com.database.iot.model.entities.FitnessMachine;

public class FitnessMachineController extends AbstractGenericControllerImpl<FitnessMachine> {
    private final FitnessMachineDaoImpl fitnessMachineDao = new FitnessMachineDaoImpl();

    @Override
    public AbstractGenericDaoImpl<FitnessMachine> getDao(){
        return fitnessMachineDao;
    }
}