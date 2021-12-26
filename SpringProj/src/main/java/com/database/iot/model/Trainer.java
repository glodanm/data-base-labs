package com.database.iot.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "trainer", schema = "lab_1")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", length = 45)
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "phone_number")
    private String phone_number;
    @Column(name = "client_with_trainer_id")
    private Integer client_with_trainer_id;

}
