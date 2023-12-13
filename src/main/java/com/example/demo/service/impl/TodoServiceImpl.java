package com.example.demo.service.impl;

import com.example.demo.client.TodoClient;
import com.example.demo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl {

    @Autowired
    TodoClient todoClient;

    public List<Todo> getAllTodos() {
        return todoClient.getTodos();
    }

}
