package com.database.iot.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "exercise")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
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

    public Exercise(Integer id, Integer burning_calories, Integer time_of_set,
                    Integer training_type_id, Integer fitness_machine_id) {
        this.id = id;
        this.burning_calories = burning_calories;
        this.time_of_set = time_of_set;
        this.training_type_id = training_type_id;
        this.fitness_machine_id = fitness_machine_id;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", burning_calories=" + burning_calories +
                ", time_of_set=" + time_of_set +
                ", training_type_id=" + training_type_id +
                ", fitness_machine_id=" + fitness_machine_id +
                '}';
    }
}
