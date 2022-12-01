package com.example.demotodo.todo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TodoController {

    private ArrayList<String> todoList = new ArrayList<>();

    @GetMapping("/list")
    public ArrayList<String> list(){
        return todoList;
    }

    @GetMapping("/receiveList")
    public ArrayList<String> receiveList(String todo){
        if(!todoList.contains(todo)){
            todoList.add(todo);
        }


        return todoList;
    }

    @GetMapping("deleteList")
    ArrayList<String> deleteList(int todo){

        todoList.remove(todo);

        return todoList;
    }

}
