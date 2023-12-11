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

@RestController
@RequestMapping("/dots")
public class DotsController {

    @Autowired
    public DotsRepository dotsRepository;

    public DotService dotService = new DotService();

    @RequestMapping(produces = MediaType.TEXT_PLAIN_VALUE, value = "/get_res")
    public ResponseEntity<String> dotHandler(@Valid @RequestBody DotDTO req) {
        DotEntity dot = DotEntity.builder().x(req.getX()).y(req.getY()).r(req.getR()).build();
        dot.setInside(dotService.check(dot));
        dotsRepository.save(dot);
        return ResponseEntity.ok(dot.getInside().toString());
    }

}
