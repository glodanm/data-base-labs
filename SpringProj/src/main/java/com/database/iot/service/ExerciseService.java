package com.database.iot.service;

import com.database.iot.DTO.ExerciseDTO;
import com.database.iot.mapper.ExerciseMapper;
import com.database.iot.model.Exercise;
import com.database.iot.repository.ExerciseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service

public class ExerciseService {
    private final ExerciseRepository exerciseRepository;

    public List<Exercise> getAllExercise() {
        return exerciseRepository.findAll();
    }

    public Exercise getExerciseById(Integer id) {
        return exerciseRepository.findById(id).orElse(null);
    }

    public Exercise createExercise(ExerciseDTO exerciseDTO) {
        return exerciseRepository.save(ExerciseMapper.mapDTOToExercise(exerciseDTO));
    }

    public Exercise updateExercise(ExerciseDTO exerciseDTO) {
        if (getExerciseById(exerciseDTO.getId()) != null) {
            return exerciseRepository.save(ExerciseMapper.mapDTOToExercise(exerciseDTO));
        }
        return null;
    }

    public Exercise deleteExerciseById(Integer id) {
        Exercise exercise = getExerciseById(id);
        if (exercise != null) {
            exerciseRepository.deleteById(id);
            return exercise;
        }
        return null;
    }
}