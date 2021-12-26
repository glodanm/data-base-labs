package com.database.iot.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class TrainerDTO {
    private Integer id;
    private String name;
    private String surname;
    private String phone_number;
    private Integer client_with_trainer_id;
}
