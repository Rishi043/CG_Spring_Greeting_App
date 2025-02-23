package com.greetingapp;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class GreetingService {

    private final Map<String, String> greetings = new LinkedHashMap<>();
    private int idCounter = 1;

    // UC2: Returns a simple greeting message
    public String getSimpleGreetingMessage() {
        return "Hello, Welcome!";
    }

    // UC3: Returns a personalized greeting message based on user attributes
    public String getGreetingMessage(String firstName, String lastName) {
        String message;
        if (firstName != null && lastName != null) {
            message = "Hello " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            message = "Hello " + firstName + "!";
        } else if (lastName != null) {
            message = "Hello " + lastName + "!";
        } else {
            message = "Hello World!";
        }
        saveGreetingMessage(message);
        return message;
    }

    // UC4: Saves a greeting message with a generated ID
    private void saveGreetingMessage(String message) {
        String id = "id-" + idCounter++;
        greetings.put(id, message);
    }

    // UC-5: Finds a greeting message by ID in the repository
    public String getGreetingById(String id) {
        return greetings.getOrDefault(id, "Greeting not found.");
    }

    // UC-4 & UC-6: Returns all stored greeting messages
    public Map<String, String> getAllGreetings() {
        return greetings;
    }

}
