package com.database.iot.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class ClientDTO {
    private Integer id;
    private String first_name;
    private String second_name;
    private String email;
    private String phone_number;
    private Integer training_type_id;
}