package com.example.demotodo2.controller;


import com.example.demotodo2.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TodoListController {

    @Autowired
    TodoListService ts;

    @GetMapping("/list")
    public ArrayList<String> list(){
        return ts.selectTodo();
    }

    @GetMapping("/receiveList")
    public ArrayList<String> receivelist(String todo){
        ts.insertTodo(todo);
        return ts.selectTodo();
    }

    @GetMapping("/deleteList")
    public ArrayList<String> deletelist(int todo){

        ts.deleteTodo(ts.selectTodo().get(todo));
        return ts.selectTodo();
    }

}
