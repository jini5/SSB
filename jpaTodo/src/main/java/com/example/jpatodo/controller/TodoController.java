package com.example.jpatodo.controller;

import com.example.jpatodo.dto.TodoResponse;
import com.example.jpatodo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/todos")
    public List<TodoResponse> todolists(){
        return todoService.todoList();
    }

    @DeleteMapping("/todos/{id}")
    public String deleteTodos(@PathVariable("id") String id){
        return todoService.deleteTodos(id);
    }

    @PostMapping("/todos")
    public String insertTodos(String todos){
        return todoService.insertTodos(todos);
    }

}
