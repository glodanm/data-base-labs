package com.database.iot.model.entities;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "training_type")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class TrainingType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "type", length = 45)
    private String type;
    @Column(name = "number_of_sets")
    private String number_of_sets;
    @Column(name = "numbers_of_days")
    private Integer numbers_of_days;

    public TrainingType(Integer id, String type, String number_of_sets, Integer numbers_of_days) {
        this.id = id;
        this.type = type;
        this.number_of_sets = number_of_sets;
        this.numbers_of_days = numbers_of_days;
    }

    @Override
    public String toString() {
        return "TrainingType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", number_of_sets='" + number_of_sets + '\'' +
                ", numbers_of_days=" + numbers_of_days +
                '}';
    }
}
