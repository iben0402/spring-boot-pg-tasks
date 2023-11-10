package com.example.task2.astronaut.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode

public class GetAstronautResponse {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Spaceship {
        private UUID id;
        private String name;
        private int capacity;
    }

    private UUID id;
    private String name;
    private int yearOfBirth;
    private Spaceship spaceship;
}

