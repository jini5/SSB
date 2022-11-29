package com.example.demotodo2.service;

import com.example.demotodo2.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TodoListService {

    @Autowired
    TodoListRepository tr;

    public int insertTodo(String todo){
        return tr.insertTodo(todo);
    }

    public ArrayList<String> selectTodo() {
        return tr.selectTodo();
    }

    public int deleteTodo(String todo){
        return tr.deleteTodo(todo);
    }
}
