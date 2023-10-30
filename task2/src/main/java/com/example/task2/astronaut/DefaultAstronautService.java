package com.example.task2.astronaut;

import com.example.task2.spaceship.Spaceship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DefaultAstronautService implements AstronautService {
    private final AstronautRepository astronautRepository;

    @Autowired
    public DefaultAstronautService(AstronautRepository astronautRepository) {
        this.astronautRepository = astronautRepository;
    }

    public Astronaut findAstronautByID(UUID id) {
        return astronautRepository.findAstronautByID(id);
    }

    public List<Astronaut> findAstronautsBySpaceship(Spaceship spaceship) {
        return astronautRepository.findBySpaceship(spaceship);
    }

    public List<Astronaut> findAllAstronauts() {
        return astronautRepository.findAll();
    }

    public void create(Astronaut astronaut) {
        astronautRepository.save(astronaut);
    }

    public void update(Astronaut astronaut) {
        astronautRepository.save(astronaut);
    }

    public void delete(UUID ID) {
        astronautRepository.delete(this.findAstronautByID(ID));
    }
}