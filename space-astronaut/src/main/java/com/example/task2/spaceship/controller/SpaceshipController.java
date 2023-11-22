package com.example.task2.spaceship.controller;

import com.example.task2.spaceship.dto.GetSpaceshipResponse;
import com.example.task2.spaceship.dto.GetSpaceshipsResponse;
import com.example.task2.spaceship.dto.PatchSpaceshipRequest;
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

}
