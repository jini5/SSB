package com.example.jpatest01.service.impl;

import com.example.jpatest01.dto.UserRequest;
import com.example.jpatest01.entity.User;
import com.example.jpatest01.repository.UserRepository;
import com.example.jpatest01.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;




    @Override
    public String insertUser(UserRequest userRequest) {
        try{
            userRepository.save(userRequest.toEntity());
        }catch (Exception e){
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }

    @Override
    public String selectUser(UserRequest userRequest) {
        User user =userRepository.findByEmailAndPassword(userRequest.getEmail(),userRequest.getPassword()).orElse(null);
        if(user!=null){
           return "success";
        }else{
            return "failed";
        }

    }
}
