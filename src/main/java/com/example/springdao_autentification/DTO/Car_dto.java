package com.example.springdao_autentification.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Car_dto {
    @Size(min = 3,max = 55,message = "Кол во букв")
    @NotEmpty
    private String model;
    @Min(value = 50)
    @Max(value = 2000)
    @NotNull
    private Integer power;
    @Min(value = 1000)
    @Max(value = 9999999)
    @NotNull
    private Integer price;
    @NotEmpty
    @Size(min = 3,max = 55)
    private String password;
    private String username;

}
