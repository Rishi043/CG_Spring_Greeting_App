package com.greetingapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired                                   // Autowired Annotation
    private GreetingService greetingService;

    // for UC-2
    @GetMapping
    public String getGreeting() {
        return greetingService.getGreetingMessage();      // by calling the method
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

