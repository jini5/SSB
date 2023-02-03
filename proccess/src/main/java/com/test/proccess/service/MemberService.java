package com.test.proccess.service;

import com.test.proccess.dto.MemberRequestDTO;
import com.test.proccess.dto.MemberResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    MemberResponseDTO insertMember(MemberRequestDTO request);
}
