package com.database.iot.controller;

import com.database.iot.DTO.GymDTO;
import com.database.iot.mapper.GymMapper;
import com.database.iot.model.Gym;
import com.database.iot.service.GymService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/gym")

public class GymController {
    private final GymService gymService;

    @GetMapping
    public List<GymDTO> getAllGym() {
        return gymService.getAllGym().stream().map(GymMapper::mapGymToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GymDTO> getGymById(@PathVariable("id") Integer id) {
        Gym gym = gymService.getGymById(id);
        if (gym == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                GymMapper.mapGymToDTO(gym), HttpStatus.OK);
    }

    @PostMapping
    public GymDTO createGym(@RequestBody GymDTO gymDTO) {
        return GymMapper.mapGymToDTO(gymService.createGym(gymDTO));
    }

    @PutMapping
    public ResponseEntity<GymDTO> updateGym(@RequestBody GymDTO gymDTO) {
        Gym gym = gymService.getGymById(gymDTO.getId());
        if (gym == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                GymMapper.mapGymToDTO(gymService.updateGym(gymDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<GymDTO> deleteGymById(@PathVariable("id") Integer id) {
        Gym gym = gymService.getGymById(id);
        if (gym == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                GymMapper.mapGymToDTO(gymService.deleteGymById(id)), HttpStatus.OK
        );
    }
}