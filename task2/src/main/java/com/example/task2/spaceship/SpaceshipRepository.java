package com.example.task2.spaceship;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpaceshipRepository extends JpaRepository<Spaceship, UUID> {

}