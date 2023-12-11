package com.vovi.backend_new.controllers;

import com.vovi.backend_new.entity.UserEntity;
import com.vovi.backend_new.dto.UserDTO;
import com.vovi.backend_new.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @Autowired
    public UserRepository userRepository;

    @RequestMapping(produces = MediaType.TEXT_PLAIN_VALUE, value = "/login")
    public ResponseEntity<String> loginHandler(@Valid @RequestBody UserDTO req) {
        if (userRepository.existsByLoginAndPassword(req.getLogin(), req.getPassword())) {
            return ResponseEntity.ok("ok");
        }
        return ResponseEntity.ok("fail");
    }

    @RequestMapping(produces = MediaType.TEXT_PLAIN_VALUE, value = "/register")
    public ResponseEntity<String> registrationHandler(@Valid @RequestBody UserDTO req) {
        if (!userRepository.existsByLogin(req.getLogin())) {
            userRepository.save(UserEntity.builder().login(req.getLogin()).password(req.getPassword()).build());
            return ResponseEntity.ok("ok");
        }
        return ResponseEntity.ok("fail");
    }
}
