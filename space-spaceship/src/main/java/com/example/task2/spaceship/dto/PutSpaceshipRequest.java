package com.example.task2.spaceship.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutSpaceshipRequest {
    private String name;
    private int capacity;
}
