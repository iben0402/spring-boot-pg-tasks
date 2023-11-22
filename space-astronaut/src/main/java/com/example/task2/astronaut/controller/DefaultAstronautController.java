package com.example.task2.astronaut.controller;

import com.example.task2.astronaut.dto.GetAstronautResponse;
import com.example.task2.astronaut.dto.GetAstronautsResponse;
import com.example.task2.astronaut.dto.PatchAstronautRequest;
import com.example.task2.astronaut.dto.PutAstronautRequest;
import com.example.task2.astronaut.function.AstronautToResponseFunction;
import com.example.task2.astronaut.function.AstronautsToResponseFunction;
import com.example.task2.astronaut.function.RequestToAstronautFunction;
import com.example.task2.astronaut.function.UpdateAstronautWithRequestFunction;
import com.example.task2.astronaut.service.AstronautService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
public class DefaultAstronautController implements AstronautController{
    private final AstronautService service;
    private final AstronautToResponseFunction astronautToResponse;
    private final AstronautsToResponseFunction astronautsToResponse;
    private final RequestToAstronautFunction requestToAstronaut;
    private final UpdateAstronautWithRequestFunction updateAstronautWithRequest;

    @Autowired
    public DefaultAstronautController(
            AstronautService service,
            AstronautToResponseFunction astronautToResponse,
            AstronautsToResponseFunction astronautsToResponse,
            RequestToAstronautFunction requestToAstronaut,
            UpdateAstronautWithRequestFunction updateAstronautWithRequest) {
        this.service = service;
        this.astronautToResponse = astronautToResponse;
        this.astronautsToResponse = astronautsToResponse;
        this.requestToAstronaut = requestToAstronaut;
        this.updateAstronautWithRequest = updateAstronautWithRequest;
    }


    @Override
    public GetAstronautsResponse getAstronauts() {
        return astronautsToResponse.apply(service.findAllAstronauts());
    }

    @Override
    public GetAstronautsResponse getSpaceshipsAstronauts(UUID spaceshipID) {
        return service.findAstronautsBySpaceshipID(spaceshipID)
                .map(astronautsToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetAstronautResponse getAstronaut(UUID ID) {
        return service.findAstronautByID(ID)
                .map(astronautToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putAstronaut(UUID ID, PutAstronautRequest request) {
        service.create(requestToAstronaut.apply(ID, request));
    }

    @Override
    public void deleteAstronaut(UUID ID) {
        service.findAstronautByID(ID).ifPresentOrElse(
                astronaut -> service.delete(ID),
                () -> {throw new ResponseStatusException(HttpStatus.NOT_FOUND);}
        );
    }

    @Override
    public void patchAstronaut(UUID ID, PatchAstronautRequest request) {
        service.findAstronautByID(ID).ifPresentOrElse(
                astronaut -> service.update(updateAstronautWithRequest.apply(astronaut, request)),
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                });
    }
}
