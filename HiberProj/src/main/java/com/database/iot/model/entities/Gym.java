package com.database.iot.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "gym")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", length = 45)
    private String name;
    @Column(name = "sity")
    private String sity;
    @Column(name = "street")
    private String street;

    public Gym(Integer id, String name, String sity, String street) {
        this.id = id;
        this.name = name;
        this.sity = sity;
        this.street = street;
    }

    @Override
    public String toString() {
        return "Gym{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sity='" + sity + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
