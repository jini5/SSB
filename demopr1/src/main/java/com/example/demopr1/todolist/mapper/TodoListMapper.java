package com.example.demopr1.todolist.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Mapper
public interface TodoListMapper {

    public int insertTodo(String todo);
    public ArrayList<String> selectTodo();
    public int deleteTodo(String todo);


}
