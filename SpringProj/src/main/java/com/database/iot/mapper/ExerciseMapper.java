package com.database.iot.mapper;

import com.database.iot.model.Exercise;
import com.database.iot.DTO.ExerciseDTO;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class ExerciseMapper {
    public static ExerciseDTO mapExerciseToDTO(Exercise exercise){
        return new ExerciseDTO(
                exercise.getId(),
                exercise.getBurning_calories(),
                exercise.getTime_of_set(),
                exercise.getTraining_type_id(),
                exercise.getFitness_machine_id()
        );
    }

    public static Exercise mapDTOToExercise(ExerciseDTO exerciseDTO){
        return new Exercise(
                exerciseDTO.getId(),
                exerciseDTO.getBurning_calories(),
                exerciseDTO.getTime_of_set(),
                exerciseDTO.getTraining_type_id(),
                exerciseDTO.getFitness_machine_id()
        );
    }
}