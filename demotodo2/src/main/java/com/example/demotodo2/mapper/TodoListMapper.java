package com.example.demotodo2.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface TodoListMapper {

    public int insertTodo(String todo);
    public ArrayList<String> selectTodo();
    public int deleteTodo(String todo);

}
