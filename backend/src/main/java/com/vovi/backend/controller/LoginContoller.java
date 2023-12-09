package com.vovi.backend.controller;

import com.vovi.backend.dto.UserDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginContoller {

    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE, value = "/login")
    public ResponseEntity<String> handleLoginRequest(@RequestBody UserDTO req) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Cache-Control", "no-transform, public, max-age=86400");
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body("Authentication successful: " + req.getLogin() + " " + req.getPassword());
//        return ResponseEntity.ok("Auth successful Vovi u did this!");
    }
}
