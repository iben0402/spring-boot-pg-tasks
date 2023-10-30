package com.example.task2.astronaut;

import com.example.task2.spaceship.Spaceship;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public interface AstronautService {
    public Astronaut findAstronautByID(UUID id);
    public List<Astronaut> findAstronautsBySpaceship(Spaceship spaceship);

    public List<Astronaut> findAllAstronauts();

    public void create(Astronaut astronaut);

    public void update(Astronaut astronaut);

    public void delete(UUID ID);
}
