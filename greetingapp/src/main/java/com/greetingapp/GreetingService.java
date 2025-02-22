package com.greetingapp;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class GreetingService {

    private final Map<String, String> greetings = new HashMap<>();

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

    private void saveGreetingMessage(String message) {
        String id = UUID.randomUUID().toString();
        greetings.put(id, message);
    }

    public Map<String, String> getAllGreetings() {
        return new HashMap<>(greetings);
    }
}
