package com.example.task2.spaceship.service;

import com.example.task2.spaceship.entity.Spaceship;
import com.example.task2.spaceship.repository.SpaceshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DefaultSpaceshipService implements SpaceshipService {
    private final SpaceshipRepository spaceshipRepository;

    @Autowired
    public DefaultSpaceshipService(SpaceshipRepository spaceshipRepository) {
        this.spaceshipRepository = spaceshipRepository;
    }

    public Optional<Spaceship> findSpaceshipByID(UUID id) {
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
        spaceshipRepository.findSpaceshipByID(ID).ifPresent(spaceshipRepository::delete);
    }
}
