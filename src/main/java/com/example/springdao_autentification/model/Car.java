package com.example.springdao_autentification.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "Car")

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "model")
    private String model;
    @Column(name = "power")
    private int power;
    @Column(name = "price")
    private int price;
    @Temporal(TemporalType.DATE)
    @Column(name = "ddatee")
    private Date ddatee;
}
