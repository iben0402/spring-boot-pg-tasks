package com.example.task2.astronaut.function;

import com.example.task2.astronaut.dto.GetAstronautResponse;
import com.example.task2.astronaut.entity.Astronaut;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AstronautToResponseFunction  implements Function<Astronaut, GetAstronautResponse> {
    @Override
    public GetAstronautResponse apply(Astronaut astronaut) {
        return GetAstronautResponse.builder()
                .ID(astronaut.getID())
                .name(astronaut.getName())
                .yearOfBirth(astronaut.getYearOfBirth())
                .spaceship(GetAstronautResponse.Spaceship.builder()
                        .ID(astronaut.getSpaceship().getID())
                        .name(astronaut.getSpaceship().getName())
                        .capacity(astronaut.getSpaceship().getCapacity())
                        .build())
                .build();
    }
}
