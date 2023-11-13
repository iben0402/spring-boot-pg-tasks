package com.example.task2.spaceship.controller;

import com.example.task2.spaceship.dto.GetSpaceshipResponse;
import com.example.task2.spaceship.dto.GetSpaceshipsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface SpaceshipController {

    @GetMapping("api/spaceships")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSpaceshipsResponse getSpaceships();

    @GetMapping("/api/spaceships/{spaceshipID}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSpaceshipResponse getSpaceship(
            @PathVariable("ID") UUID ID
    );

    @DeleteMapping("/api/spaceships/{spaceshipID}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    void deleteSpaceship(
            @PathVariable("ID") UUID ID
    );

}
