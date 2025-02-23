package com.greetingapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/greeting") // Base URL for all requests
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    // UC-1: Returns a personalized greeting in JSON format
    @PostMapping
    public String postGreeting(@RequestBody String name) {
        return "Hello, " + name + "! Nice to meet you.";
    }

    // UC-1: Updates a greeting message
    @PutMapping
    public String putGreeting(@RequestBody String newMessage) {
        return "Updated greeting: " + newMessage;
    }

    // UC-1: Deletes a greeting
    @DeleteMapping
    public String deleteGreeting() {
        return "Greeting deleted successfully.";
    }

    // UC-2: Returns a simple greeting message
    @GetMapping("/simple")
    public String getSimpleGreeting() {
        return greetingService.getSimpleGreetingMessage();
    }

    // UC-3: Returns a greeting message based on user attributes
    @GetMapping
    public String getGreeting(@RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName) {
        return greetingService.getGreetingMessage(firstName, lastName);
    }

    // UC-4: Returns all stored greeting messages in the repository
    @GetMapping("/all")
    public Map<String, String> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    // UC-5: Finds a greeting message by ID in the repository
    @GetMapping("/{id}")
    public String getGreetingById(@PathVariable String id) {
        return greetingService.getGreetingById(id);
    }

    // UC-6: Lists all the greeting messages in the repository
    @GetMapping("/list")
    public Map<String, String> listAllGreetings() {
        return greetingService.getAllGreetings();
    }

    // UC-7: Edits a greeting message by ID in the repository
    @PutMapping("/{id}")
    public String editGreetingById(@PathVariable String id, @RequestBody String newMessage) {
        return greetingService.editGreetingById(id, newMessage);
    }

    // UC-8: Deletes a greeting message by ID in the repository
    @DeleteMapping("/{id}")
    public String deleteGreetingById(@PathVariable String id) {
        return greetingService.deleteGreetingById(id);
    }
}
