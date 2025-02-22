package com.greetingapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/greeting") // Base URL for all requests
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    // GET request - Returns a greeting message based on provided user attributes
    @GetMapping
    public String getGreeting(@RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName) {
        return greetingService.getGreetingMessage(firstName, lastName);
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

    // GET request - Returns all stored greeting messages
    @GetMapping("/all")
    public Map<String, String> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
}
