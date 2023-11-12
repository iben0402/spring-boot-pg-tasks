package com.example.task2.spaceship.repository;

import com.example.task2.spaceship.entity.Spaceship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpaceshipRepository extends JpaRepository<Spaceship, UUID> {
    Optional<Spaceship> findSpaceshipByID(UUID id); // Find a spaceship by ID
}