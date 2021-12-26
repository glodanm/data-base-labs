package com.database.iot.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "client_with_trainer")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class ClientWithTrainer {

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

    public ClientWithTrainer(Integer id, String name, String surname, String phone_number) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "ClientWithTrainer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
