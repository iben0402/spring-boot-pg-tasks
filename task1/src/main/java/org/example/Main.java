package org.example;

import org.example.astronaut.Astronaut;
import org.example.astronaut.AstronautDTO;
import org.example.spaceship.Spaceship;
import org.example.serialization.SerializationHelper;
import org.example.workloadSimulator.WorkloadSimulator;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // -------------Create spaceships----------------
        Spaceship apollo = Spaceship.builder()
                .name("Apollo")
                .capacity(5)
                .astronauts(new ArrayList<>())
                .build();

        Spaceship orion = Spaceship.builder()
                .name("Orion")
                .capacity(6)
                .astronauts(new ArrayList<>())
                .build();

        Spaceship crewDragon = Spaceship.builder()
                .name("Crew Dragon")
                .capacity(7)
                .astronauts(new ArrayList<>())
                .build();
        // -------------------------------------------------


        // ----------------Create astronauts----------------
        Astronaut astronaut1 = Astronaut.builder()
                .name("Neil Armstrong")
                .yearOfBirth(1930)
                .spaceship(apollo)
                .build();

        Astronaut astronaut2 = Astronaut.builder()
                .name("Buzz Aldrin")
                .yearOfBirth(1932)
                .spaceship(apollo)
                .build();

        Astronaut astronaut3 = Astronaut.builder()
                .name("John Glenn")
                .yearOfBirth(1925)
                .spaceship(apollo)
                .build();

        Astronaut astronaut4 = Astronaut.builder()
                .name("Alan Shepard")
                .yearOfBirth(1914)
                .spaceship(apollo)
                .build();

        Astronaut astronaut5 = Astronaut.builder()
                .name("Sally Ride")
                .yearOfBirth(1932)
                .spaceship(apollo)
                .build();

        Astronaut astronaut6 = Astronaut.builder()
                .name("Ben Dover")
                .yearOfBirth(1920)
                .spaceship(apollo)
                .build();

        Astronaut astronaut7 = Astronaut.builder()
                .name("Jim Lovell")
                .yearOfBirth(1921)
                .spaceship(orion)
                .build();

        Astronaut astronaut8 = Astronaut.builder()
                .name("Gus Grissom")
                .yearOfBirth(1909)
                .spaceship(orion)
                .build();

        Astronaut astronaut9 = Astronaut.builder()
                .name("Peggy Whitson")
                .yearOfBirth(1950)
                .spaceship(orion)
                .build();

        Astronaut astronaut10 = Astronaut.builder()
                .name("Eileen Collins")
                .yearOfBirth(1948)
                .spaceship(orion)
                .build();

        Astronaut astronaut11 = Astronaut.builder()
                .name("John Young")
                .yearOfBirth(1927)
                .spaceship(orion)
                .build();

        Astronaut astronaut12 = Astronaut.builder()
                .name("Chris Hadfield")
                .yearOfBirth(1968)
                .spaceship(orion)
                .build();

        Astronaut astronaut13 = Astronaut.builder()
                .name("Mae Jemison")
                .yearOfBirth(1918)
                .spaceship(crewDragon)
                .build();

        Astronaut astronaut14 = Astronaut.builder()
                .name("Scott Kelly")
                .yearOfBirth(1924)
                .spaceship(crewDragon)
                .build();

        Astronaut astronaut15 = Astronaut.builder()
                .name("Mark Kelly")
                .yearOfBirth(19)
                .spaceship(crewDragon)
                .build();

        Astronaut astronaut16 = Astronaut.builder()
                .name("Christina H. Koch")
                .yearOfBirth(85)
                .spaceship(crewDragon)
                .build();

        Astronaut astronaut17 = Astronaut.builder()
                .name("Jessica Meir")
                .yearOfBirth(78)
                .spaceship(crewDragon)
                .build();

        Astronaut astronaut18 = Astronaut.builder()
                .name("Andrew R. Morgan")
                .yearOfBirth(90)
                .spaceship(crewDragon)
                .build();

        // -------------------------------------------------

        // -----------------Add astronauts and spaceships to lists------------------
        List<Spaceship> spaceships = Arrays.asList(apollo, orion, crewDragon);
        List<Astronaut> allAstronauts = Arrays.asList(
                astronaut1, astronaut2, astronaut3, astronaut4, astronaut5, astronaut6,
                astronaut7, astronaut8, astronaut9, astronaut10, astronaut11, astronaut12,
                astronaut13, astronaut14, astronaut15, astronaut16, astronaut17, astronaut18);

        // -------------------------------------------------

        // -----------------Print all spaceships and astronauts in original order------------------
        System.out.println("All spaceships in original order:");
        spaceships.forEach(spaceship -> {
            System.out.println(spaceship);
        });
        System.out.println();

        System.out.println("All astronauts in original order:");
        allAstronauts.forEach(character -> {
            System.out.println(character);
        });
        System.out.println();
        // -------------------------------------------------

        // -----------------Create set of all astronauts-------------------------------
        Set<Astronaut> allCharactersSet = spaceships.stream()
                .flatMap(spaceship -> spaceship.getAstronauts().stream())
                .collect(Collectors.toSet());

        System.out.println("All astronauts in set:");
        allCharactersSet.stream().forEach(System.out::println);
        System.out.println();
        //-----------------------------------------------------------------------------

        //-----------------Filter by spaceship name-------------------------------
        System.out.println("All astronauts with spaceship name 'Apollo':");
        allCharactersSet.stream()
                .filter(character -> character.getSpaceship().getName().equals("Apollo"))
                .forEach(System.out::println);
        System.out.println();
        //-----------------------------------------------------------------------------

        //-----------------Sort by name------------------------------------------------
        System.out.println("All astronauts sorted by name:");
        allCharactersSet.stream()
                .sorted(Comparator.comparing(Astronaut::getName))
                .forEach(System.out::println);
        System.out.println();
        //-----------------------------------------------------------------------------

        //-----------------map to DTO objects and sort using natural order------------------------------------------
        List<AstronautDTO> astronautDTOS = allCharactersSet.stream()
                .map(character -> new AstronautDTO(character))
                .sorted()
                .toList();

        System.out.println("All astronauts mapped to DTO objects and sorted using natural order:");
        astronautDTOS.stream()
                .forEach(System.out::println);
        System.out.println();
        //-----------------------------------------------------------------------------

        //-----------------Serialization and deserialization------------------------------------------
        SerializationHelper.serializespaceships(spaceships, "spaceships.ser");

        List<Spaceship> deserializedSpaceships = SerializationHelper.deserializespaceships("spaceships.ser");
        System.out.println("All spaceships deserialized from spaceships.ser:");
        deserializedSpaceships.stream()
                .forEach(System.out::println);

        System.out.println();
        //-----------------------------------------------------------------------------

        //-----------------Parallel stream------------------------------------------
        System.out.println("All astronauts in parallel stream:");
        ForkJoinPool customThreadPool = new ForkJoinPool(4); // Change the pool size as needed

        try {
            spaceships.parallelStream()
                    .flatMap(spaceship -> spaceship.getAstronauts().stream())
                    .forEach(character -> customThreadPool.execute(() -> WorkloadSimulator.simulateWorkload(character)));

        } finally {
            // Shutdown the thread pool to release resources
            customThreadPool.shutdown();
        }

        try {
            // Wait until all tasks have completed
            customThreadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}