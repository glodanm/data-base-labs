package com.database.iot.controller.impl;

import com.database.iot.model.dao.impl.AbstractGenericDaoImpl;
import com.database.iot.model.dao.impl.TrainingTypeDaoImpl;
import com.database.iot.model.entities.TrainingType;

public class TrainingTypeController extends AbstractGenericControllerImpl<TrainingType> {
    private final TrainingTypeDaoImpl trainingTypeDao = new TrainingTypeDaoImpl();

    @Override
    public AbstractGenericDaoImpl<TrainingType> getDao(){
        return trainingTypeDao;
    }
}