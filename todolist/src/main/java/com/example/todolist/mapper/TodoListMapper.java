package com.example.todolist.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface TodoListMapper {


    public int insertTodo(String todo);
    public ArrayList<HashMap<String,Object>> selectTodo();

    public int deleteTodo(HashMap<String,Object> params);

}
