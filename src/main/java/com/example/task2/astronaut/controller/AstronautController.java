package com.example.task2.astronaut.controller;

import com.example.task2.astronaut.dto.GetAstronautResponse;
import com.example.task2.astronaut.dto.GetAstronautsResponse;
import com.example.task2.astronaut.dto.PatchAstronautRequest;
import com.example.task2.astronaut.dto.PutAstronautRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface AstronautController {
    @GetMapping("api/astronauts")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetAstronautsResponse getAstronauts();

    @GetMapping("/api/spaceships/{spaceshipID}/astronauts")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetAstronautsResponse getSpaceshipsAstronauts(
            @PathVariable("spaceshipID") UUID spaceshipID
    );

    @GetMapping("/api/astronauts/{ID}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetAstronautResponse getAstronaut(
            @PathVariable("ID") UUID ID
    );

    @PutMapping("/api/astronauts/{ID}")
    @ResponseStatus(HttpStatus.CREATED)
    void putAstronaut(
            @PathVariable("ID") UUID ID,
            @RequestBody PutAstronautRequest request
    );

    @DeleteMapping("/api/astronauts/{ID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAstronaut(
            @PathVariable("ID") UUID ID
    );

    @PatchMapping("/api/astronauts/{ID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void patchAstronaut(
            @PathVariable("ID") UUID ID,
            @RequestBody PatchAstronautRequest request
    );

}
