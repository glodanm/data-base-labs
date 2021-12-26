package com.database.iot.mapper;

import com.database.iot.DTO.TrainerDTO;
import com.database.iot.model.Trainer;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class TrainerMapper {
    public static TrainerDTO mapTrainerToDTO(Trainer trainer){
        return new TrainerDTO(
                trainer.getId(),
                trainer.getName(),
                trainer.getSurname(),
                trainer.getPhone_number(),
                trainer.getClient_with_trainer_id()
        );
    }

    public static Trainer mapDTOToTrainer(TrainerDTO trainerDTO){
        return new Trainer(
                trainerDTO.getId(),
                trainerDTO.getName(),
                trainerDTO.getSurname(),
                trainerDTO.getPhone_number(),
                trainerDTO.getClient_with_trainer_id()
        );
    }
}