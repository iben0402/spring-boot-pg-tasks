package com.example.task2.spaceship.function;

import com.example.task2.spaceship.dto.GetSpaceshipsResponse;
import com.example.task2.spaceship.entity.Spaceship;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class SpaceshipsToResponseFunction implements Function<List<Spaceship>, GetSpaceshipsResponse>{

    @Override
    public GetSpaceshipsResponse apply(List<Spaceship> entities) {
        return GetSpaceshipsResponse.builder()
                .spaceships(entities.stream()
                        .map(spaceship -> GetSpaceshipsResponse.Spaceship.builder()
                                .ID(spaceship.getID())
                                .name(spaceship.getName())
                                .build())
                        .toList())
                .build();
    }

}
