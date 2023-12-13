package com.example.demo;

import com.example.demo.client.TodoClient;
import com.example.demo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class DemoApplication {

    @Autowired
    TodoClient todoClient;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    void runAfterStartup() {
//        List<Todo> todos = todoClient.getTodos();
//        todos.forEach(System.out::println);
//    }

}
