package com.example.springdao_autentification.controler;

import com.example.springdao_autentification.DTO.Car_Copy_dto;
import com.example.springdao_autentification.DTO.Car_dto;
import com.example.springdao_autentification.model.Car;
import com.example.springdao_autentification.repository.Car_repository;
import com.example.springdao_autentification.service.Car_service;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Car_Controler {
   private final Car_service carService;

   @PostMapping("/register")
   public Car_Copy_dto register(@Valid @RequestBody Car_dto carDto, BindingResult bindingResult){
      if (bindingResult.hasErrors()){
         List<FieldError> fieldErrors = bindingResult.getFieldErrors();
         fieldErrors.forEach(x-> System.out.println(x));
         throw new RegistrationExpsh("Возникла ошибка");
      } else {
         return carService.register(carDto);
      }
   }
   @GetMapping("/all")
   public List<Car_Copy_dto> all(){
      return carService.all();
   }

   @DeleteMapping("/delete/{model}")
   public void deleteByModel(@PathVariable(name = "model") String model){
      carService.deleteByModel(model);
   }

}
class RegistrationExpsh extends RuntimeException{
   public RegistrationExpsh(String message) {
      super(message);
   }
}
