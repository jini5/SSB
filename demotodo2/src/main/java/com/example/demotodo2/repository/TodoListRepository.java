package com.example.demotodo2.repository;


import com.example.demotodo2.mapper.TodoListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class TodoListRepository {

    @Autowired
    TodoListMapper mapper;


    public int insertTodo(String todo) {
        return mapper.insertTodo(todo);
    }


    public ArrayList<String> selectTodo(){
        return mapper.selectTodo();
    }

    public int deleteTodo(String todo) {
        return mapper.deleteTodo(todo);
    }

}
