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
@Table(name = "client", schema = "lab_1")

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


}
