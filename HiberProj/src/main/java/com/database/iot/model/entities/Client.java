package com.database.iot.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "client")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "first_name", length = 45)
    private String first_name;
    @Column(name = "second_name")
    private String second_name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phone_number;
    @Column(name = "training_type_id")
    private Integer training_type_id;

    public Client(Integer id, String first_name, String second_name,
                  String email, String phone_number,Integer training_type_id){
        this.id=id;
        this.first_name=first_name;
        this.second_name=second_name;
        this.email=email;
        this.phone_number=phone_number;
        this.training_type_id=training_type_id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", training_type_id=" + training_type_id +
                '}';
    }
}
