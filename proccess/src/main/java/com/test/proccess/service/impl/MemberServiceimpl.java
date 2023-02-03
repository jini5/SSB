package com.test.proccess.service.impl;

import com.test.proccess.dto.MemberRequestDTO;
import com.test.proccess.dto.MemberResponseDTO;
import com.test.proccess.repository.MemberRepository;
import com.test.proccess.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceimpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public MemberResponseDTO insertMember(MemberRequestDTO request){

        try{
            memberRepository.save(request.toEntity());
        }catch (Exception e){
            return MemberResponseDTO.builder()
                    .code("ERROR")
                    .content(e.getMessage())
                    .build();
        }

        return MemberResponseDTO.builder()
                .build();
    }

}
