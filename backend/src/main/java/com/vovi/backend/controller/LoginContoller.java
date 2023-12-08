package com.vovi.backend.controller;

import com.vovi.backend.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginContoller {
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> handleLoginRequest(@RequestBody UserDTO req) {
        return ResponseEntity.ok("Authentication successful: " + req.getLogin() + " " + req.getPassword());
    }
}
