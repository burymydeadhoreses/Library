package io.github.burymydeadhoreses.library.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
    @GetMapping("/")
    String getHelloMessage() {
        return "Greetings";
    }
}
