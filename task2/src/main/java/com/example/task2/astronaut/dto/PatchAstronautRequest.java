package com.example.task2.astronaut.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode

public class PatchAstronautRequest {
    private String name;
    private int yearOfBirth;
}
