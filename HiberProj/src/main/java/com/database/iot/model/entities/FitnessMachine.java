package com.database.iot.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "fitness_machine")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class FitnessMachine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "type_machine")
    private String type_machine;

    public FitnessMachine(Integer id, String type_machine) {
        this.id = id;
        this.type_machine = type_machine;
    }

    @Override
    public String toString() {
        return "FitnessMachine{" +
                "id=" + id +
                ", type_machine='" + type_machine + '\'' +
                '}';
    }
}
