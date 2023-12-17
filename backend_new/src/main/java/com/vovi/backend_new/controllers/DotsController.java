package com.vovi.backend_new.controllers;

import com.vovi.backend_new.dto.DotDTO;
import com.vovi.backend_new.entity.DotEntity;
import com.vovi.backend_new.repository.DotsRepository;
import com.vovi.backend_new.service.DotService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dots")
public class DotsController {

    @Autowired
    public DotsRepository dotsRepository;

    public DotService dotService = new DotService();

    @RequestMapping(produces = MediaType.TEXT_PLAIN_VALUE, value = "/check")
    public ResponseEntity<String> dotHandler(@Valid @RequestBody DotDTO req) {
        DotEntity dot = DotEntity.builder().x(req.getX()).y(req.getY()).r(req.getR()).inside(dotService.check(req)).build();
        dotsRepository.save(dot);
        return ResponseEntity.ok(dot.getInside().toString());
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/fetch")
    public ResponseEntity<List<DotEntity>> fetchHandler() {
        List<DotEntity> dots = dotsRepository.findAll();
        return ResponseEntity.ok(dots);
    }

}
