package com.example.demochat.chat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@RestController
public class ChatController {

    static ArrayList<ArrayList<String>> msgList = new ArrayList<ArrayList<String>>();


    @GetMapping("/chat/getMsg")
    public ArrayList<ArrayList<String>> msg(){

        return msgList;
    }
    @GetMapping("/chat/sendMsg")
    public void receiveMsg(HttpSession session, String msg){
        ArrayList<String>  msgContant = new ArrayList<>();
        if((msg==null)||(msg.equals(""))){
            return;
        }

        String nickName = String.valueOf(session.getAttribute("nickName"));

        SimpleDateFormat format1 = new SimpleDateFormat(("yyyy-MM-dd HH:mm:ss"));
        Date time = new Date();
        String timeStr = format1.format(time);

        msgContant.add(nickName);
        msgContant.add(msg);
        msgContant.add(timeStr);

        msgList.add(msgContant);
        System.out.println(msgList.toString());
    }

}
