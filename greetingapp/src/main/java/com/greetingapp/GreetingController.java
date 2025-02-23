package com.greetingapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/greeting") // Base URL for all requests
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    // UC1: Returns a personalized greeting in JSON format
    @PostMapping
    public String postGreeting(@RequestBody String name) {
        return "Hello, " + name + "! Nice to meet you.";
    }

    // UC1: Updates a greeting message
    @PutMapping
    public String putGreeting(@RequestBody String newMessage) {
        return "Updated greeting: " + newMessage;
    }

    // UC1: Deletes a greeting
    @DeleteMapping
    public String deleteGreeting() {
        return "Greeting deleted successfully.";
    }

    // UC2: Returns a simple greeting message
    @GetMapping("/simple")
    public String getSimpleGreeting() {
        return greetingService.getSimpleGreetingMessage();
    }

    // UC3: Returns a greeting message based on user attributes
    @GetMapping
    public String getGreeting(@RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName) {
        return greetingService.getGreetingMessage(firstName, lastName);
    }

    // UC4: Returns all stored greeting messages in the repository
    @GetMapping("/all")
    public Map<String, String> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
}
