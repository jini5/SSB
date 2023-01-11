package com.example.jpatest01.controller;

import com.example.jpatest01.dto.ScheduleResponse;
import com.example.jpatest01.service.ScheduleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ScheduleControllerTest {

    protected MockHttpSession session;


    // 내부적 호출
    // (메서드)구현체가 완성되어있지 않아도 테스트 가능
    //@Mock
    //HttpSession session;

    @Mock
    private ScheduleService scheduleService;

    @InjectMocks
    private ScheduleController scheduleController;

    @Test
    @DisplayName("Schedule Controller Select Test")
    void scheduleSelectTest(){
        ScheduleResponse response = new ScheduleResponse("10","title","2023-01-10");
        List<ScheduleResponse> result= new ArrayList<>();
        result.add(response);

        //조건 : 무엇을 호출하면 무엇을 돌려준다.
        given(scheduleController.scheduleList(session)).willReturn(result);
        List<ScheduleResponse> testResult = scheduleController.scheduleList(session);
        Assertions.assertEquals("10",testResult.get(0).getId());

    }


// -- 외부호출 MockMVC--

    private MockMvc mockMvc;

    @BeforeEach  //세션이 미리값을 넣는등의 준비
    void setUp(@Autowired ScheduleController scheduleController) {
        // MockMvc
        mockMvc = MockMvcBuilders.standaloneSetup(scheduleController).build();
    }

    @Test
    @Transactional //이걸 없애면 실제 실행되어 commit된다.
    void scheduleDeleteTest() throws Exception {
        mockMvc.perform(delete("/schedules/10")) //호출 url
                .andExpect(status().isOk()) //결과 200(정상) 호출이 되어야함
                .andExpect(content().string("success")) //응답이 "success"로 나와야함
                .andDo(print()); //출력
    }




    @Test
    @Transactional //이걸 없애면 실제 실행되어 commit된다.
    void scheduleMockSelectTest() throws Exception {
        mockMvc.perform(get("/schedules").session(session).param("", ""))
                .andExpect(status().isOk()) //결과 200(정상) 호출이 되어야함
                .andDo(print()); //출력
    }


}