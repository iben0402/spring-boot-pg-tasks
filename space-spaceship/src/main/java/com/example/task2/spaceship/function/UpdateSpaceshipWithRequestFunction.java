package com.example.task2.spaceship.function;

import com.example.task2.spaceship.dto.PatchSpaceshipRequest;
import com.example.task2.spaceship.entity.Spaceship;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class UpdateSpaceshipWithRequestFunction implements BiFunction<Spaceship, PatchSpaceshipRequest, Spaceship> {
    @Override
    public Spaceship apply(Spaceship entity, PatchSpaceshipRequest request) {
        return Spaceship.builder()
                .ID(entity.getID())
                .name(request.getName())
                .capacity(request.getCapacity())
                .build();

    }
}
