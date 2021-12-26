package com.database.iot.controller;

import com.database.iot.DTO.ExerciseDTO;
import com.database.iot.mapper.ExerciseMapper;
import com.database.iot.model.Exercise;
import com.database.iot.service.ExerciseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/exercise")

public class ExerciseController {
    private final ExerciseService exerciseService;

    @GetMapping
    public List<ExerciseDTO> getAllExercise() {
        return exerciseService.getAllExercise().stream().map(ExerciseMapper::mapExerciseToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseDTO> getExerciseById(@PathVariable("id") Integer id) {
        Exercise exercise = exerciseService.getExerciseById(id);
        if (exercise == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                ExerciseMapper.mapExerciseToDTO(exercise), HttpStatus.OK);
    }

    @PostMapping
    public ExerciseDTO createExercise(@RequestBody ExerciseDTO exerciseDTO) {
        return ExerciseMapper.mapExerciseToDTO(exerciseService.createExercise(exerciseDTO));
    }

    @PutMapping
    public ResponseEntity<ExerciseDTO> updateExercise(@RequestBody ExerciseDTO exerciseDTO) {
        Exercise exercise = exerciseService.getExerciseById(exerciseDTO.getId());
        if (exercise == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                ExerciseMapper.mapExerciseToDTO(exerciseService.updateExercise(exerciseDTO))
                , HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ExerciseDTO> deleteExercise(@PathVariable("id") Integer id) {
        Exercise exercise = exerciseService.getExerciseById(id);
        if (exercise == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                ExerciseMapper.mapExerciseToDTO(exerciseService.deleteExerciseById(id)), HttpStatus.OK
        );
    }
}