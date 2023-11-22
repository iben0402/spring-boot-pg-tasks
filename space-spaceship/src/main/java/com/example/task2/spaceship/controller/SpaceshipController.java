package com.example.task2.spaceship.controller;

import com.example.task2.spaceship.dto.GetSpaceshipResponse;
import com.example.task2.spaceship.dto.GetSpaceshipsResponse;
import com.example.task2.spaceship.dto.PatchSpaceshipRequest;
import com.example.task2.spaceship.dto.PutSpaceshipRequest;
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
            @PathVariable("spaceshipID") UUID ID
    );

    @PutMapping("/api/spaceships/{spaceshipID}")
    @ResponseStatus(HttpStatus.CREATED)
    void putSpaceship(
            @PathVariable("spaceshipID") UUID ID,
            @RequestBody PutSpaceshipRequest request
    );

    @DeleteMapping("/api/spaceships/{spaceshipID}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    void deleteSpaceship(
            @PathVariable("spaceshipID") UUID ID
    );

    @PatchMapping("/api/spaceships/{spaceshipID}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    void patchSpaceship(
            @PathVariable("spaceshipID") UUID ID,
            @RequestBody PatchSpaceshipRequest request
    );

}
