package com.example.task2.spaceship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DefaultSpaceshipService implements SpaceshipService {
    private final SpaceshipRepository spaceshipRepository;

    @Autowired
    public DefaultSpaceshipService(SpaceshipRepository spaceshipRepository) {
        this.spaceshipRepository = spaceshipRepository;
    }

    public Spaceship findSpaceshipByID(UUID id) {
        return spaceshipRepository.findSpaceshipByID(id);
    }

    public List<Spaceship> findAllSpaceships() {
        return spaceshipRepository.findAll();
    }

    public void create(Spaceship spaceship) {
        spaceshipRepository.save(spaceship);
    }

    public void update(Spaceship spaceship) {
        spaceshipRepository.save(spaceship);
    }

    public void delete(UUID ID) {
        spaceshipRepository.delete(findSpaceshipByID(ID));
    }
}
