package com.api.ebd.hellojid.controller;

import com.api.ebd.hellojid.model.Auto;
import com.api.ebd.hellojid.service.AutoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auto")
public class AutoController {
    private static final Logger logger = LogManager.getLogger("PersonController");
    private final AutoService autoService;

    public AutoController(AutoService autoService){
        this.autoService = autoService;
    }

    @GetMapping
    public ResponseEntity<List<Auto>> findAll() {
        return ResponseEntity.ok(autoService.listAllAutos());
    }
    @PostMapping
    public ResponseEntity create(@RequestBody Auto auto) {
        Auto p = null;
        try {
            p = autoService.createAuto(auto);
        } catch (Exception e) {
            logger.error("Cannot create a person", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return new ResponseEntity(p, HttpStatus.CREATED);
    }
}
