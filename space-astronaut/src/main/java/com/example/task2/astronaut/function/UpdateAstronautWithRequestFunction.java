package com.example.task2.astronaut.function;

import com.example.task2.astronaut.dto.PatchAstronautRequest;
import com.example.task2.astronaut.entity.Astronaut;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class UpdateAstronautWithRequestFunction implements BiFunction<Astronaut, PatchAstronautRequest, Astronaut> {
    @Override
    public Astronaut apply(Astronaut entity, PatchAstronautRequest request) {
        return Astronaut.builder()
                .ID(entity.getID())
                .name(request.getName())
                .yearOfBirth(request.getYearOfBirth())
                .spaceship(entity.getSpaceship())
                .build();
    }
}
