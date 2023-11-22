package com.example.task2.astronaut.initialize;

import com.example.task2.astronaut.entity.Astronaut;
import com.example.task2.astronaut.service.AstronautService;
import com.example.task2.spaceship.service.SpaceshipService;
import com.example.task2.spaceship.entity.Spaceship;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {

    private final AstronautService astronautService;
    private final SpaceshipService spaceshipService;

    @Autowired
    public InitializeData(AstronautService astronautService, SpaceshipService spaceshipService) {
        this.astronautService = astronautService;
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
                .ID(UUID.fromString("00000000-0000-0000-0000-000000000000"))
                .name("Apollo")
                .capacity(5)
                .astronauts(new ArrayList<>())
                .build();

        Spaceship orion = Spaceship.builder()
                .ID(UUID.fromString("00000000-0000-0000-0000-000000000001"))
                .name("Orion")
                .capacity(6)
                .astronauts(new ArrayList<>())
                .build();

        Spaceship crewDragon = Spaceship.builder()
                .ID(UUID.fromString("00000000-0000-0000-0000-000000000002"))
                .name("Crew Dragon")
                .capacity(7)
                .astronauts(new ArrayList<>())
                .build();

        // Save spaceships using SpaceshipService
        spaceshipService.create(apollo);
        spaceshipService.create(orion);
        spaceshipService.create(crewDragon);

        // Create Astronauts
        List<Astronaut> astronauts = new ArrayList<>();

        astronauts.add(Astronaut.builder()
                .ID(UUID.fromString("00000000-0000-0000-0000-000000000000"))
                .name("Neil Armstrong")
                .yearOfBirth(1930)
                .spaceship(apollo)
                .build());

        astronauts.add(Astronaut.builder()
                .ID(UUID.fromString("00000000-0000-0000-0000-000000000001"))
                .name("Buzz Aldrin")
                .yearOfBirth(1932)
                .spaceship(apollo)
                .build());

        astronauts.add(Astronaut.builder()
                .ID(UUID.fromString("00000000-0000-0000-0000-000000000002"))
                .name("John Glenn")
                .yearOfBirth(1925)
                .spaceship(apollo)
                .build());

        astronauts.add(Astronaut.builder()
                .ID(UUID.fromString("00000000-0000-0000-0000-000000000003"))
                .name("Alan Shepard")
                .yearOfBirth(1914)
                .spaceship(apollo)
                .build());

        astronauts.add(Astronaut.builder()
                .ID(UUID.fromString("00000000-0000-0000-0000-000000000004"))
                .name("Sally Ride")
                .yearOfBirth(1932)
                .spaceship(apollo)
                .build());

        astronauts.add(Astronaut.builder()
                .ID(UUID.fromString("00000000-0000-0000-0000-000000000005"))
                .name("Ben Dover")
                .yearOfBirth(1920)
                .spaceship(apollo)
                .build());

        astronauts.add(Astronaut.builder()
                .ID(UUID.fromString("00000000-0000-0000-0000-000000000006"))
                .name("Jim Lovell")
                .yearOfBirth(1921)
                .spaceship(orion)
                .build());

        astronauts.add(Astronaut.builder()
                .ID(UUID.fromString("00000000-0000-0000-0000-000000000007"))
                .name("Gus Grissom")
                .yearOfBirth(1909)
                .spaceship(orion)
                .build());

        astronauts.add(Astronaut.builder()
                .ID(UUID.fromString("00000000-0000-0000-0000-000000000008"))
                .name("Peggy Whitson")
                .yearOfBirth(1950)
                .spaceship(orion)
                .build());

        astronauts.add(Astronaut.builder()
                .ID(UUID.fromString("00000000-0000-0000-0000-000000000009"))
                .name("Eileen Collins")
                .yearOfBirth(1948)
                .spaceship(orion)
                .build());

        astronauts.add(Astronaut.builder()
                .ID(UUID.fromString("00000000-0000-0000-0000-000000000010"))
                .name("John Young")
                .yearOfBirth(1927)
                .spaceship(orion)
                .build());

        astronauts.add(Astronaut.builder()
                .ID(UUID.fromString("00000000-0000-0000-0000-000000000011"))
                .name("Chris Hadfield")
                .yearOfBirth(1968)
                .spaceship(orion)
                .build());

        astronauts.add(Astronaut.builder()
                .ID(UUID.fromString("00000000-0000-0000-0000-000000000012"))
                .name("Mae Jemison")
                .yearOfBirth(1918)
                .spaceship(crewDragon)
                .build());

        astronauts.add(Astronaut.builder()
                .ID(UUID.fromString("00000000-0000-0000-0000-000000000013"))
                .name("Scott Kelly")
                .yearOfBirth(1924)
                .spaceship(crewDragon)
                .build());

        astronauts.add(Astronaut.builder()
                .ID(UUID.fromString("00000000-0000-0000-0000-000000000014"))
                .name("Mark Kelly")
                .yearOfBirth(19)
                .spaceship(crewDragon)
                .build());

        astronauts.add(Astronaut.builder()
                .ID(UUID.fromString("00000000-0000-0000-0000-000000000015"))
                .name("Christina H. Koch")
                .yearOfBirth(85)
                .spaceship(crewDragon)
                .build());

        astronauts.add(Astronaut.builder()
                .ID(UUID.fromString("00000000-0000-0000-0000-000000000016"))
                .name("Jessica Meir")
                .yearOfBirth(78)
                .spaceship(crewDragon)
                .build());

        astronauts.add(Astronaut.builder()
                .ID(UUID.fromString("00000000-0000-0000-0000-000000000017"))
                .name("Andrew R. Morgan")
                .yearOfBirth(90)
                .spaceship(crewDragon)
                .build());


        // Save astronauts using AstronautService
        for (Astronaut astronaut : astronauts) {
            astronautService.create(astronaut);
        }
    }
}
