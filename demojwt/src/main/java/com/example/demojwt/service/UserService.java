package com.example.demojwt.service;

import com.example.demojwt.dto.UserDTO;
import com.example.demojwt.entity.User;
import com.example.demojwt.jwt.JwtProvider;
import com.example.demojwt.repository.TokenRepository;
import com.example.demojwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    public String signup(UserDTO userDTO){

        userRepository.save(userDTO.toEntity());
        return "success";
    }

    public String signin(UserDTO userDTO){
        Optional<User> loggedIn = userRepository.findByEmailAndPassword(userDTO.getEmail(),userDTO.getPassword());
        try{
            User user = loggedIn.get();
            return jwtProvider.token(user);
        }catch (NoSuchElementException e){
            return "failed";
        }

    }
}
