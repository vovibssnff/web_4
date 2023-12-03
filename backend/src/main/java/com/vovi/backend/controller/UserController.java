package com.vovi.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:8081")
public class UserController {

    @GetMapping("/shit")
    public ResponseEntity ping() {
        try {
            return ResponseEntity.ok("Server goes brrrrrr");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Error((((");
        }
    }



}
