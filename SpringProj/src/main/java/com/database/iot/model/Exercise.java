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
@Table(name = "exercise", schema = "lab_1")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "burning_calories", length = 45)
    private Integer burning_calories;
    @Column(name = "time_of_set")
    private Integer time_of_set;
    @Column(name = "training_type_id")
    private Integer training_type_id;
    @Column(name = "fitness_machine_id")
    private Integer fitness_machine_id;

}
