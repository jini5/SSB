package com.example.demopr1.todolist.service;

import com.example.demopr1.todolist.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TodoService {

    @Autowired
    TodoListRepository tr;

    public int insertTodo(String todo){
        return tr.insertTodo(todo);
    }

    public ArrayList<String> selectTodo(){
        return tr.selectTodo();
    }

    public int deleteTodo(String todo){
        return tr.deleteTodo(todo);
    }


}
