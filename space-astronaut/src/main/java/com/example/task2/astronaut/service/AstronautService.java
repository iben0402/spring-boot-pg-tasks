package com.example.task2.astronaut.service;

import com.example.task2.astronaut.entity.Astronaut;
import com.example.task2.spaceship.entity.Spaceship;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AstronautService {
    public Optional<Astronaut> findAstronautByID(UUID id);
    public List<Astronaut> findAstronautsBySpaceship(Spaceship spaceship);
    public Optional<List<Astronaut>> findAstronautsBySpaceshipID(UUID spaceshipID);

    public List<Astronaut> findAllAstronauts();

    public void create(Astronaut astronaut);

    public void update(Astronaut astronaut);

    public void delete(UUID ID);
}
