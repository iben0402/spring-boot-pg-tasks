package com.example.task2.astronaut.function;

import com.example.task2.astronaut.dto.PutAstronautRequest;
import com.example.task2.astronaut.entity.Astronaut;
import com.example.task2.spaceship.entity.Spaceship;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToAstronautFunction implements BiFunction<UUID, PutAstronautRequest, Astronaut> {
    @Override
    public Astronaut apply(UUID id, PutAstronautRequest request) {
        return Astronaut.builder()
                .ID(id)
                .name(request.getName())
                .yearOfBirth(request.getYearOfBirth())
                .spaceship(Spaceship.builder()
                        .ID(request.getSpaceship())
                        .build())
                .build();
    }
}
