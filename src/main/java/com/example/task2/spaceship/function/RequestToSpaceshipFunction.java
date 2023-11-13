package com.example.task2.spaceship.function;

import com.example.task2.spaceship.dto.PutSpaceshipRequest;
import com.example.task2.spaceship.entity.Spaceship;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToSpaceshipFunction implements BiFunction<UUID, PutSpaceshipRequest, Spaceship> {
    @Override
    public Spaceship apply(UUID id, PutSpaceshipRequest request) {
        return Spaceship.builder()
                .ID(id)
                .name(request.getName())
                .capacity(request.getCapacity())
                .astronauts(new ArrayList<>())
                .build();
    }
}
