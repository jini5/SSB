package com.example.reservation.dto;

import com.example.reservation.entity.Account;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class AccountSignUpResponse {

    private String usrId;
    private String usrNm;
    private String usrType;

    public AccountSignUpResponse(Account acc) {
        this.usrId = acc.getUsrId();
        this.usrNm = acc.getUsrNm();
        this.usrType = acc.getUsrType();
    }

}
