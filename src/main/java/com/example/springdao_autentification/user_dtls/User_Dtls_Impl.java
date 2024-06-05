package com.example.springdao_autentification.user_dtls;


import com.example.springdao_autentification.DTO.Car_Copy_dto;
import com.example.springdao_autentification.model.Car;
import com.example.springdao_autentification.repository.Car_repository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class User_Dtls_Impl implements UserDetailsService {
   private final Car_repository carRepository;


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Car_Copy_dto byName = findByUsername(username);
        return new User(byName.getUsername(),byName.getPassword(),
                List.of(new SimpleGrantedAuthority(byName.getAuthority())));

    }
    private Car_Copy_dto findByUsername(String name){
      return   carRepository.findByUsername(name);
    }
}
