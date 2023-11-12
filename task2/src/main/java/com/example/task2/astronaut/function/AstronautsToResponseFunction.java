package com.example.task2.astronaut.function;

import com.example.task2.astronaut.dto.GetAstronautResponse;
import com.example.task2.astronaut.dto.GetAstronautsResponse;
import com.example.task2.astronaut.entity.Astronaut;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class AstronautsToResponseFunction implements Function<List<Astronaut>, GetAstronautsResponse> {
    @Override
    public GetAstronautsResponse apply(List<Astronaut> entities) {
        return GetAstronautsResponse.builder()
                .astronauts(entities.stream()
                        .map(astronaut -> GetAstronautsResponse.Astronaut.builder()
                                .ID(astronaut.getID())
                                .name(astronaut.getName())
                                .build())
                        .toList())
                .build();
    }

}
