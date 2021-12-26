package com.database.iot.controller;

import com.database.iot.DTO.TrainerDTO;
import com.database.iot.mapper.TrainerMapper;
import com.database.iot.model.Trainer;
import com.database.iot.service.TrainerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/trainer")

public class TrainerController {
    private final TrainerService trainerService;

    @GetMapping
    public List<TrainerDTO> getAllTrainer() {
        return trainerService.getAllTrainer().stream().map(TrainerMapper::mapTrainerToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainerDTO> getTrainerById(@PathVariable("id") Integer id) {
        Trainer trainer = trainerService.getTrainerById(id);
        if (trainer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                TrainerMapper.mapTrainerToDTO(trainer), HttpStatus.OK);
    }

    @PostMapping
    public TrainerDTO createTrainer(@RequestBody TrainerDTO trainerDTO) {
        return TrainerMapper.mapTrainerToDTO(trainerService.createTrainer(trainerDTO));
    }

    @PutMapping
    public ResponseEntity<TrainerDTO> updateTrainer(@RequestBody TrainerDTO trainerDTO) {
        Trainer trainer = trainerService.getTrainerById(trainerDTO.getId());
        if (trainer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                TrainerMapper.mapTrainerToDTO(trainerService.updateTrainer(trainerDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<TrainerDTO> deleteTrainer(@PathVariable("id") Integer id) {
        Trainer trainer = trainerService.getTrainerById(id);
        if (trainer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                TrainerMapper.mapTrainerToDTO(trainerService.deleteTrainerById(id)), HttpStatus.OK
        );
    }
}