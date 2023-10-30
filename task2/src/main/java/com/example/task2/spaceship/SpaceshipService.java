package com.example.task2.spaceship;

import java.util.List;
import java.util.UUID;

public interface SpaceshipService {
    public Spaceship findSpaceshipByID(UUID id);

    public List<Spaceship> findAllSpaceships();

    public void create(Spaceship spaceship);

    public void update(Spaceship spaceship);

    public void delete(UUID ID);
}