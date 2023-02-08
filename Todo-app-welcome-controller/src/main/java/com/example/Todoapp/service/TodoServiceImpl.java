package com.example.Todoapp.service;

import com.example.Todoapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    TodoRepository todoRepository;

    @Override
    public void deleteAllTodos() {
        todoRepository.deleteAll();

    }
}
