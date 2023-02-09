package com.example.demojwt.repository;

import com.example.demojwt.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token,String> {

    boolean existsByToken(String token);

}
