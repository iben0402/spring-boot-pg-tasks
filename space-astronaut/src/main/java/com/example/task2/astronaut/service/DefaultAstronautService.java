package com.example.task2.astronaut.service;

import com.example.task2.astronaut.entity.Astronaut;
import com.example.task2.astronaut.repository.AstronautRepository;
import com.example.task2.spaceship.entity.Spaceship;
import com.example.task2.spaceship.repository.SpaceshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DefaultAstronautService implements AstronautService {
    private final AstronautRepository astronautRepository;
    private final SpaceshipRepository spaceshipRepository;

    @Autowired
    public DefaultAstronautService(AstronautRepository astronautRepository, SpaceshipRepository spaceshipRepository) {
        this.astronautRepository = astronautRepository;
        this.spaceshipRepository = spaceshipRepository;
    }

    public Optional<Astronaut> findAstronautByID(UUID id) {
        return astronautRepository.findByID(id);
    }

    public List<Astronaut> findAstronautsBySpaceship(Spaceship spaceship) {
        return astronautRepository.findAllBySpaceship(spaceship);
    }

    @Override
    public Optional<List<Astronaut>> findAstronautsBySpaceshipID(UUID spaceshipID) {
        return spaceshipRepository.findSpaceshipByID(spaceshipID).map(astronautRepository::findAllBySpaceship);
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
        astronautRepository.findByID(ID).ifPresent(astronautRepository::delete);
    }
}