package com.example.guineapig.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TestApiControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHelloEndpoint() throws Exception {
        mockMvc.perform(get("/api/test/hello"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Hello from Guinea Pig!"))
                .andExpect(jsonPath("$.timestamp").exists());
    }

    @Test
    void testGreetEndpoint() throws Exception {
        mockMvc.perform(get("/api/test/greet/John"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Hello, John!"))
                .andExpect(jsonPath("$.timestamp").exists());
    }

    @Test
    void testStatusEndpoint() throws Exception {
        mockMvc.perform(get("/api/test/status"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value("UP"))
                .andExpect(jsonPath("$.service").value("guinea-pig"))
                .andExpect(jsonPath("$.timestamp").exists());
    }

    @Test
    void testEchoEndpoint() throws Exception {
        String jsonRequest = "{\"test\":\"data\",\"number\":42}";
        
        mockMvc.perform(post("/api/test/echo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.received.test").value("data"))
                .andExpect(jsonPath("$.received.number").value(42))
                .andExpect(jsonPath("$.timestamp").exists());
    }
}
