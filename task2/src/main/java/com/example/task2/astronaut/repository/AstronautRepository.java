package com.example.task2.astronaut.repository;

import com.example.task2.astronaut.entity.Astronaut;
import com.example.task2.spaceship.entity.Spaceship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AstronautRepository extends JpaRepository<Astronaut, UUID> {

    Astronaut findAstronautByID(UUID id); // Find an astronaut by ID
    List<Astronaut> findBySpaceship(Spaceship spaceship); // Find astronauts by spaceship name

}

