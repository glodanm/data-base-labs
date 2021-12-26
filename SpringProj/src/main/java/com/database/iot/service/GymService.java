package com.database.iot.service;

import com.database.iot.DTO.GymDTO;
import com.database.iot.mapper.GymMapper;
import com.database.iot.model.Gym;
import com.database.iot.repository.GymRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service

public class GymService {
    private final GymRepository gymRepository;

    public List<Gym> getAllGym() {
        return gymRepository.findAll();
    }

    public Gym getGymById(Integer id) {
        return gymRepository.findById(id).orElse(null);
    }

    public Gym createGym(GymDTO gymDTO) {
        return gymRepository.save(GymMapper.mapDTOToGym(gymDTO));
    }

    public Gym updateGym(GymDTO gymDTO) {
        if (getGymById(gymDTO.getId()) != null) {
            return gymRepository.save(GymMapper.mapDTOToGym(gymDTO));
        }
        return null;
    }

    public Gym deleteGymById(Integer id) {
        Gym gym = getGymById(id);
        if (gym != null) {
            gymRepository.deleteById(id);
            return gym;
        }
        return null;
    }
}