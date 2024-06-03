package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

@RestController
public class HomePageRestController {

    @Value("${developer.name}")
    private String developerName;

    @GetMapping("/")
    public String getHomePage() {
        return "Hello, World!";
    }

    @GetMapping("/props")
    public List<String> getProperties() {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("src/main/resources/application.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.entrySet().stream()
                .map(entry -> entry.getKey() + ":" + entry.getValue())
                .toList();
    }

    @GetMapping("dev")
    public String getDeveloperName() {
        return developerName;
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 10k!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day!";
    }
}
