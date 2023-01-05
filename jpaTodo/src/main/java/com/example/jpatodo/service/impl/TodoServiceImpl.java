package com.example.jpatodo.service.impl;


import com.example.jpatodo.dto.TodoResponse;
import com.example.jpatodo.entity.Todo;
import com.example.jpatodo.repository.TodoRepository;
import com.example.jpatodo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository repo;

    @Override
    public List<TodoResponse> todoList() {
        return repo.findAll().stream()
                .map(en->new TodoResponse(en))
                .collect(Collectors.toList());
    }

    @Override
    public String deleteTodos(String id) {
        try{
            repo.deleteById(Long.valueOf(id));
        }catch(Exception e){
            return "failed";
        }
        return "success";
    }

    @Override
    public String insertTodos(String todos) {
        try {
            repo.save(Todo.builder()
                    .todos(todos)
                    .build());
        }catch(Exception e){
            //e.printStackTrace();
            return "failed";
        }
        return "success";
    }
}
