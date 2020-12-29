package com.aska.development.carrestapi.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "manufacture")
    private String manufacture;

    @Column(name = "model")
    private String model;

    @Column(name = "type")
    private String type;

    @Column(name = "country")
    private String country;

    @Temporal(TemporalType.DATE)
    @Column(name = "createDate")
    private Date createDate;

}
