package com.api.ebd.hellojid.controller;

import com.api.ebd.hellojid.service.AutoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autos")
public class AutoController {
    private static final Logger logger = LogManager.getLogger("PersonController");
    private final AutoService autoService;

    public AutoController(AutoService autoService){
        this.autoService = autoService;
    }
}
