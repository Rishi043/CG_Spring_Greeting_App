package com.greetingapp;

// Importing required Spring Boot annotations
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting") // Base URL for all requests
public class GreetingController {

    // GET request - Returns a simple greeting message
    @GetMapping
    public String getGreeting() {
        return "Hello, Welcome!";
    }

    // POST request - Takes a name and returns a personalized greeting
    @PostMapping
    public String postGreeting(@RequestBody String name) {
        return "Hello, " + name + "! Nice to meet you.";
    }

    // PUT request - Updates a greeting message
    @PutMapping
    public String putGreeting(@RequestBody String newMessage) {
        return "Updated greeting: " + newMessage;
    }

    // DELETE request - Deletes a greeting
    @DeleteMapping
    public String deleteGreeting() {
        return "Greeting deleted successfully.";
    }
}
