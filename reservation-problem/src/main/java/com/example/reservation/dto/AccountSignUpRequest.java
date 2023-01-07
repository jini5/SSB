package com.example.reservation.dto;

import com.example.reservation.entity.Account;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AccountSignUpRequest {

    private String usrId;
    private String grId;
    private String usrPw;
    private String usrNm;
    private String usrType;

    @Builder
    public AccountSignUpRequest(String usrId, String grId, String usrPw, String usrNm, String usrType) {
        this.usrId = usrId;
        this.grId = grId;
        this.usrPw = usrPw;
        this.usrNm = usrNm;
        this.usrType = usrType;
    }

    public Account toEntity() {
        return Account.builder().
                usrId(usrId)
                .grId(grId)
                .usrNm(usrNm)
                .usrType(usrType)
                .build();
    }

}
