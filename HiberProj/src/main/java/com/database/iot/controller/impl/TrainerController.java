package com.database.iot.controller.impl;

import com.database.iot.model.dao.impl.AbstractGenericDaoImpl;
import com.database.iot.model.dao.impl.TrainerDaoImpl;
import com.database.iot.model.entities.Trainer;

public class TrainerController extends AbstractGenericControllerImpl<Trainer> {
    private final TrainerDaoImpl trainerDao = new TrainerDaoImpl();

    @Override
    public AbstractGenericDaoImpl<Trainer> getDao(){
        return trainerDao;
    }
}