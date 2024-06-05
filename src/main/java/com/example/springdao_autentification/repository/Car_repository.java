package com.example.springdao_autentification.repository;

import com.example.springdao_autentification.DTO.Car_Copy_dto;
import com.example.springdao_autentification.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface Car_repository extends JpaRepository<Car_Copy_dto,Integer> {

    Car_Copy_dto findByUsername(String username);
    @Transactional
    @Modifying
    void deleteByModel(String model);
}
