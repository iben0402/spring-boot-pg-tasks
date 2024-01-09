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
public class PutAstronautRequest {
    private String name;
    private int yearOfBirth;
    private UUID spaceship;
}
