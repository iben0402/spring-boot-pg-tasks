package com.example.task2.spaceship.function;

import com.example.task2.spaceship.dto.GetSpaceshipResponse;
import com.example.task2.spaceship.entity.Spaceship;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SpaceshipToResponseFunction implements Function<Spaceship, GetSpaceshipResponse> {

    @Override
    public GetSpaceshipResponse apply(Spaceship spaceship) {
        return GetSpaceshipResponse.builder()
                .ID(spaceship.getID())
                .name(spaceship.getName())
                .capacity(spaceship.getCapacity())
                .build();
    }
}
