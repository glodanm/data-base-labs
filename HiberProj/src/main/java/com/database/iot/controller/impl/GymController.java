package com.database.iot.controller.impl;

import com.database.iot.model.dao.impl.AbstractGenericDaoImpl;
import com.database.iot.model.dao.impl.GymDaoImpl;
import com.database.iot.model.entities.Gym;

public class GymController extends AbstractGenericControllerImpl<Gym> {
    private final GymDaoImpl gymDao = new GymDaoImpl();

    @Override
    public AbstractGenericDaoImpl<Gym> getDao(){
        return gymDao;
    }
}