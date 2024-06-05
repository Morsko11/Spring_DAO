package com.example.springdao_autentification.service;

import com.example.springdao_autentification.DTO.Car_Copy_dto;
import com.example.springdao_autentification.DTO.Car_dto;
import com.example.springdao_autentification.model.Car;
import com.example.springdao_autentification.repository.Car_repository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Car_service {
  private final   Car_repository carRepository;
  private  final PasswordEncoder passwordEncoder;
  public Car_Copy_dto register(Car_dto carDto) {
    Car_Copy_dto car = new Car_Copy_dto();
    car.setModel(carDto.getModel());
    car.setDdatee(new Date());
    car.setPrice(carDto.getPrice());
    car.setPower(carDto.getPower());
    car.setPassword(passwordEncoder.encode(carDto.getPassword()));
    car.setUsername(carDto.getUsername());
    car.setAuthority("user");
    return carRepository.save(car);
  }

  public List<Car_Copy_dto> all() {
    return carRepository.findAll();
  }

  public void deleteByModel(String model) {
    carRepository.deleteByModel(model);
  }
}
