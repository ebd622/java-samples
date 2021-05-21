package com.api.ebd.hellojid.service;

import com.api.ebd.hellojid.dao.AutoRepository;
import com.api.ebd.hellojid.model.Auto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoService {
    private static final Logger logger = LogManager.getLogger("PersonService");
    private final AutoRepository autoRepository;

    public AutoService(final AutoRepository autoRepository){
        this.autoRepository = autoRepository;
    }

    public Auto createAuto(Auto auto){
        return autoRepository.save(auto);
    }

    public List<Auto> listAllAutos() {
        return (List<Auto>) autoRepository.findAll();
    }

}
