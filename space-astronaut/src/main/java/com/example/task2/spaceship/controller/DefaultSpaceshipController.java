package com.example.task2.spaceship.controller;

import com.example.task2.spaceship.dto.PutSpaceshipRequest;
import com.example.task2.spaceship.entity.Spaceship;
import com.example.task2.spaceship.service.SpaceshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.UUID;

@RestController
public class DefaultSpaceshipController implements SpaceshipController {

    private final SpaceshipService service;


    @Autowired
    public DefaultSpaceshipController(SpaceshipService service) {
        this.service = service;
    }

    @Override
    public void deleteSpaceship(UUID ID) {
        service.findSpaceshipByID(ID)
                .ifPresentOrElse(
                        spaceship -> service.delete(ID),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

    @Override
    public void putSpaceship(UUID ID) {
        if(service.findSpaceshipByID(ID).isEmpty()) {
            this.service.create(
                    Spaceship.builder()
                            .ID(ID)
                            .build()
            );
        }
    }
}
