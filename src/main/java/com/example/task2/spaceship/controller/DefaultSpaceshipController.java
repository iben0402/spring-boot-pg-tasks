package com.example.task2.spaceship.controller;

import com.example.task2.spaceship.dto.GetSpaceshipResponse;
import com.example.task2.spaceship.dto.GetSpaceshipsResponse;
import com.example.task2.spaceship.dto.PatchSpaceshipRequest;
import com.example.task2.spaceship.dto.PutSpaceshipRequest;
import com.example.task2.spaceship.function.RequestToSpaceshipFunction;
import com.example.task2.spaceship.function.SpaceshipToResponseFunction;
import com.example.task2.spaceship.function.SpaceshipsToResponseFunction;
import com.example.task2.spaceship.function.UpdateSpaceshipWithRequestFunction;
import com.example.task2.spaceship.service.SpaceshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
public class DefaultSpaceshipController implements SpaceshipController {

    private final SpaceshipService service;
    private final SpaceshipToResponseFunction spaceshipToResponse;
    private final SpaceshipsToResponseFunction spaceshipsToResponse;
    private final RequestToSpaceshipFunction requestToSpaceship;
    private final UpdateSpaceshipWithRequestFunction updateSpaceshipWithRequest;


    @Autowired
    public DefaultSpaceshipController(
            SpaceshipService service,
            SpaceshipToResponseFunction spaceshipToResponse,
            SpaceshipsToResponseFunction spaceshipsToResponse,
            RequestToSpaceshipFunction requestToSpaceship, UpdateSpaceshipWithRequestFunction updateSpaceshipWithRequest) {
        this.service = service;
        this.spaceshipToResponse = spaceshipToResponse;
        this.spaceshipsToResponse = spaceshipsToResponse;
        this.requestToSpaceship = requestToSpaceship;
        this.updateSpaceshipWithRequest = updateSpaceshipWithRequest;
    }
    @Override
    public GetSpaceshipsResponse getSpaceships() {
        return spaceshipsToResponse.apply(service.findAllSpaceships());
    }

    @Override
    public GetSpaceshipResponse getSpaceship(UUID ID) {
        return service.findSpaceshipByID(ID)
                .map(spaceshipToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putSpaceship(UUID ID, PutSpaceshipRequest request) {
        service.create(requestToSpaceship.apply(ID, request));
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
    public void patchSpaceship(UUID ID, PatchSpaceshipRequest request) {
        service.findSpaceshipByID(ID)
                .ifPresentOrElse(
                        spaceship -> service.update(updateSpaceshipWithRequest.apply(spaceship, request)),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}
