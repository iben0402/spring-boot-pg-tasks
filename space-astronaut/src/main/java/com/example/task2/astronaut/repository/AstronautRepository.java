package com.example.task2.astronaut.repository;

import com.example.task2.astronaut.entity.Astronaut;
import com.example.task2.spaceship.entity.Spaceship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AstronautRepository extends JpaRepository<Astronaut, UUID> {

    Optional<Astronaut> findByID(UUID id); // Find an astronaut by ID
    List<Astronaut> findAllBySpaceship(Spaceship spaceship); // Find astronauts by spaceship
    List<Astronaut> findAllBySpaceshipID (UUID ID); // Find astronauts by spaceship ID

}

