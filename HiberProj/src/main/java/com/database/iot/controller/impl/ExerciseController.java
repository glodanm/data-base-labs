package com.database.iot.controller.impl;

import com.database.iot.model.dao.impl.AbstractGenericDaoImpl;
import com.database.iot.model.dao.impl.ExerciseDaoImpl;
import com.database.iot.model.entities.Exercise;

public class ExerciseController extends AbstractGenericControllerImpl<Exercise> {
    private final ExerciseDaoImpl exerciseDao = new ExerciseDaoImpl();

    @Override
    public AbstractGenericDaoImpl<Exercise> getDao(){
        return exerciseDao;
    }
}