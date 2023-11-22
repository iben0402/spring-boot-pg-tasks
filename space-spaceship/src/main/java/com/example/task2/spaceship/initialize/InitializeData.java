package com.example.task2.spaceship.initialize;

import com.example.task2.spaceship.service.SpaceshipService;
import com.example.task2.spaceship.entity.Spaceship;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("initializeDataSpaceship")
public class InitializeData implements InitializingBean {

    private final SpaceshipService spaceshipService;

    @Autowired
    public InitializeData(SpaceshipService spaceshipService) {
        this.spaceshipService = spaceshipService;
    }

    @Override
    public void afterPropertiesSet() {
        if (spaceshipService.findAllSpaceships().isEmpty()) {
            createExampleData();
        }
    }

    private void createExampleData() {
        System.out.println("INITIALIZING DATA");
        // Create Spaceships
        Spaceship apollo = Spaceship.builder()
                .ID(UUID.fromString("00000001-0000-0000-0000-000000000000"))
                .name("Apollo")
                .capacity(5)
                .build();

        Spaceship orion = Spaceship.builder()
                .ID(UUID.fromString("00000001-0000-0000-0000-000000000001"))
                .name("Orion")
                .capacity(6)
                .build();

        Spaceship crewDragon = Spaceship.builder()
                .ID(UUID.fromString("00000001-0000-0000-0000-000000000002"))
                .name("Crew Dragon")
                .capacity(7)
                .build();

        // Save spaceships using SpaceshipService
        spaceshipService.create(apollo);
        spaceshipService.create(orion);
        spaceshipService.create(crewDragon);
    }
}
