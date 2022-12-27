package com.example.todolist.repository;

import com.example.todolist.mapper.TodoListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;


@Repository
public class TodoListRepository {

    @Autowired
    TodoListMapper mapper;

    public int insertTodo(String todo){
        return mapper.insertTodo(todo);
    }


    public ArrayList<HashMap<String,Object>> selectTodo(){
        return mapper.selectTodo();
    }

    public int deleteTodo(HashMap<String,Object> params){
        return mapper.deleteTodo(params);
    }

}

