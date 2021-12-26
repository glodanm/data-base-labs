package com.database.iot.DTO;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TrainingTypeDTO {
    private Integer id;
    private String type;
    private Integer number_of_sets;
    private Integer numbers_of_days;
}
