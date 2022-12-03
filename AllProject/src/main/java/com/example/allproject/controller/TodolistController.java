package com.example.allproject.controller;

import com.example.allproject.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class TodolistController {


    @Autowired
    TodoListService ts;

    @GetMapping("/list")
    public ArrayList<HashMap<String,Object>> list(){
        return ts.selectTodo();
    }

    @GetMapping("/receiveList")
    public ArrayList<HashMap<String,Object>> receivelist(String todo){
        ts.insertTodo(todo);

        return ts.selectTodo();
    }

    @GetMapping("/deleteList")
    public ArrayList<HashMap<String,Object>> deletelist(int todo){

        //ts.deleteTodo(ts.selectTodo().get(todo));
        HashMap<String,Object> param = new HashMap<>();
        param.put("id",todo);
        ts.deleteTodo(param);


        return ts.selectTodo();
    }
}
