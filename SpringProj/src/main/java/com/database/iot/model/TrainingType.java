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
@Table(name = "training_type", schema = "lab_1")
public class TrainingType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "type", length = 45)
    private String type;
    @Column(name = "number_of_sets")
    private Integer number_of_sets;
    @Column(name = "numbers_of_days")
    private Integer numbers_of_days;

}
