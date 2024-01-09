package com.example.task2.spaceship.event.repository.api;

import java.util.UUID;

public interface SpaceshipEventRepository {
    void delete(UUID ID);

    void create(UUID ID);
}
