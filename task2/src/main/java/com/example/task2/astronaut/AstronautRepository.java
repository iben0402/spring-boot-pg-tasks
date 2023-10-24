package com.example.task2.astronaut;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AstronautRepository extends JpaRepository<Astronaut, UUID> {

    List<Astronaut> findBySpaceshipName(String spaceshipName);

}

