package com.database.iot.service;

import com.database.iot.DTO.TrainerDTO;
import com.database.iot.mapper.ClientMapper;
import com.database.iot.mapper.TrainerMapper;
import com.database.iot.model.Trainer;
import com.database.iot.repository.TrainerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service

public class TrainerService {
    private final TrainerRepository trainerRepository;

    public List<Trainer> getAllTrainer() {
        return trainerRepository.findAll();
    }

    public Trainer getTrainerById(Integer id) {
        return trainerRepository.findById(id).orElse(null);
    }

    public Trainer createTrainer(TrainerDTO trainerDTO) {
        return trainerRepository.save(TrainerMapper.mapDTOToTrainer(trainerDTO));
    }

    public Trainer updateTrainer(TrainerDTO trainerDTO) {
        if (getTrainerById(trainerDTO.getId()) != null) {
            return trainerRepository.save(TrainerMapper.mapDTOToTrainer(trainerDTO));
        }
        return null;
    }

    public Trainer deleteTrainerById(Integer id) {
        Trainer trainer = getTrainerById(id);
        if (trainer != null) {
            trainerRepository.deleteById(id);
            return trainer;
        }
        return null;
    }
}