package com.example.demo.client;

import com.example.demo.model.Todo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "todos", url = "http://jsonplaceholder.typicode.com")
public interface TodoClient {
	@RequestMapping(method = RequestMethod.GET, value = "/todos")
	List<Todo> getTodos();

}