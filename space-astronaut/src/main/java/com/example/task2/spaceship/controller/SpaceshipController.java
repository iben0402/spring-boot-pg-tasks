package com.example.task2.spaceship.controller;

import com.example.task2.spaceship.dto.PutSpaceshipRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface SpaceshipController {
    @DeleteMapping("/api/spaceships/{spaceshipID}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    void deleteSpaceship(
            @PathVariable("spaceshipID") UUID ID
    );

    @PutMapping("/api/spaceships/{spaceshipID}")
    @ResponseStatus(HttpStatus.CREATED)
    void putSpaceship(
            @PathVariable("spaceshipID") UUID ID
    );

}
