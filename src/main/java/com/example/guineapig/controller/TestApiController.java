package com.example.guineapig.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/test")
@Tag(name = "Test API", description = "Test endpoints for demonstration")
public class TestApiController {

    @GetMapping("/hello")
    @Operation(summary = "Hello endpoint", description = "Returns a simple hello message")
    public ResponseEntity<Map<String, String>> hello() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from Guinea Pig!");
        response.put("timestamp", LocalDateTime.now().toString());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/greet/{name}")
    @Operation(summary = "Personalized greeting", description = "Returns a personalized greeting message")
    public ResponseEntity<Map<String, String>> greet(
            @Parameter(description = "Name of the person to greet") 
            @PathVariable String name) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, " + name + "!");
        response.put("timestamp", LocalDateTime.now().toString());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/status")
    @Operation(summary = "Health status", description = "Returns the current status of the application")
    public ResponseEntity<Map<String, Object>> status() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("service", "guinea-pig");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/echo")
    @Operation(summary = "Echo endpoint", description = "Echoes back the received data")
    public ResponseEntity<Map<String, Object>> echo(@RequestBody Map<String, Object> data) {
        Map<String, Object> response = new HashMap<>();
        response.put("received", data);
        response.put("timestamp", LocalDateTime.now().toString());
        return ResponseEntity.ok(response);
    }
}
