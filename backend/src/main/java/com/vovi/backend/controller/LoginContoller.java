package com.vovi.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8081")
public class LoginContoller {

    @RequestMapping(method = RequestMethod.POST, path="/login")
    public ResponseEntity<String> handleLoginRequest(@RequestParam String login, @RequestParam String password) {
        return ResponseEntity.ok("Authentication successful: " + login + " " + password);
    }
}
