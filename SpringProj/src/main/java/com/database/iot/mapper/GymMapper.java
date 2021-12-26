package com.database.iot.mapper;

import com.database.iot.model.Gym;
import com.database.iot.DTO.GymDTO;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class GymMapper {
    public static GymDTO mapGymToDTO(Gym gym){
        return new GymDTO(
                gym.getId(),
                gym.getName(),
                gym.getSity(),
                gym.getStreet()
        );
    }

    public static Gym mapDTOToGym(GymDTO gymDTO){
        return new Gym(
                gymDTO.getId(),
                gymDTO.getName(),
                gymDTO.getSity(),
                gymDTO.getStreet()
                );
    }
}