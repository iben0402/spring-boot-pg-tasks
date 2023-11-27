package com.example.task2.spaceship.event.repository.rest;

import com.example.task2.spaceship.event.repository.api.SpaceshipEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class SpaceshipEventRestRepository implements SpaceshipEventRepository {

    private final RestTemplate restTemplate;

    @Autowired
    public SpaceshipEventRestRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void delete(UUID ID) {
        restTemplate.delete("/api/spaceships/{ID}", ID);
    }

    @Override
    public void create(UUID ID) {
        restTemplate.put("/api/spaceships/{ID}", null, ID);
    }
}
