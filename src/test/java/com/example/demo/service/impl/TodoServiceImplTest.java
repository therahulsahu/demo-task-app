package com.example.demo.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 3030)
class TodoServiceImplTest {

    @Autowired
    private TodoServiceImpl todoService;

    // changing application properties to change the base url of our client
    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("app.todoUrl", () -> "http://localhost:3030");
        registry.add("spring.cloud.openfeign.client.config.default.loggerLevel", () -> "full");
    }

    @BeforeEach
    void setUp() {

    }

    // Using the WireMock APIs in the normal way:
    @Test
    public void contextLoads() throws Exception {
        // Stubbing WireMock
        stubFor(get(urlEqualTo("/todos")).willReturn(aResponse()
                .withHeader("Content-Type", "application/json").withBody("[]")));
        // We're asserting if WireMock responded properly
        todoService.getAllTodos();
    }


    @Test
    void getAllTodos() {
        todoService.getAllTodos();
    }
}