package com.database.iot.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ExerciseDTO {
    private Integer id;
    private Integer burning_calories;
    private Integer time_of_set;
    private Integer training_type_id;
    private Integer fitness_machine_id;
}
