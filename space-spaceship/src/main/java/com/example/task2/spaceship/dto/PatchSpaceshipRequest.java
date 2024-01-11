package com.example.task2.spaceship.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchSpaceshipRequest {
    private String name;
    private int capacity;
}
