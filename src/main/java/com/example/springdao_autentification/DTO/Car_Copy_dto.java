package com.example.springdao_autentification.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Car_Copy_dto")
public class Car_Copy_dto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "model")
    private String model;
    @Column(name = "power")
    private Integer power;
    @Column(name = "price")
    private Integer price;
    @Temporal(TemporalType.DATE)
    @Column(name = "ddatee")
    private Date ddatee;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "authority")
    private String authority;
}
