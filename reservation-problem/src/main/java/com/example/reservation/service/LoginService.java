package com.example.reservation.service;

import com.example.reservation.dto.AccountSignUpRequest;
import com.example.reservation.dto.AccountSignUpResponse;
import com.example.reservation.entity.Account;
import com.example.reservation.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LoginService {

    private final LoginRepository lr;

    @Autowired
    private HttpSession session;

    public AccountSignUpResponse login(AccountSignUpRequest req) {
        Account acc = req.toEntity();
        Account result = lr.findById(acc.getUsrId()).orElse(null);
        if (result != null) {
            session.setAttribute("Account", result);
            return new AccountSignUpResponse(result);
        } else {
            return null;
        }
    }

    // 필드 캡슐화
    @Autowired
    public LoginService(LoginRepository lr) {
        this.lr = lr;
    }
}
