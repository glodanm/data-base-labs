package com.database.iot.model.entities;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "trainer")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
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

    public Trainer(Integer id, String name, String surname, String phone_number,
                   Integer client_with_trainer_id) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone_number = phone_number;
        this.client_with_trainer_id = client_with_trainer_id;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", client_with_trainer_id=" + client_with_trainer_id +
                '}';
    }
}
