package com.example.demopr1.todolist.controller;

import com.example.demopr1.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
public class TodoController {


    @Autowired
    TodoService ts;


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
