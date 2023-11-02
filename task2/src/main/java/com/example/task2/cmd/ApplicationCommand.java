package com.example.task2.cmd;

import com.example.task2.astronaut.Astronaut;
import com.example.task2.astronaut.AstronautService;
import com.example.task2.spaceship.Spaceship;
import com.example.task2.spaceship.SpaceshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.UUID;

@Component
public class ApplicationCommand implements CommandLineRunner {

    private final AstronautService astronautService;
    private final SpaceshipService spaceshipService;

    @Autowired
    public ApplicationCommand(AstronautService astronautService, SpaceshipService spaceshipService) {
        this.astronautService = astronautService;
        this.spaceshipService = spaceshipService;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Enter Command: (type 'help' for list of commands)");
        Scanner scanner = new Scanner(System.in);
        String command;

        main_loop:
        while(true) {
            command = scanner.next();
            switch (command) {
                case "help" -> {
                    System.out.println("Commands: ");
                    System.out.println("help -> prints avaliable commands");
                    System.out.println("get_all_spaceships -> prints all spaceships in repository");
                    System.out.println("get_all_astronauts -> prints all astronauts in repository");
                    System.out.println("get_astronauts_by_spaceship_name -> prints all astronauts in repository with given spaceship");
                    System.out.println("add_new_astronaut -> adds new astronaut to repository");
                    System.out.println("delete_astronaut {id} -> deletes astronaut of given ID");
                    System.out.println("quit -> quits app");
                }
                case "get_all_spaceships" -> {
                    try {
                        System.out.println("Spaceships: ");
                        List<Spaceship> spaceshipList = spaceshipService.findAllSpaceships();
                        for (Spaceship spaceship : spaceshipList) {
                            System.out.println(spaceship);
                        }
                    } catch (NoSuchElementException ex) {
                        System.out.println("NOT_FOUND");
                    }
                }
                case "get_all_astronauts" -> {
                    try {
                        System.out.println("Astronauts: ");
                        List<Astronaut> astronauts = astronautService.findAllAstronauts();
                        for (Astronaut astronaut : astronauts) {
                            System.out.println(astronaut);
                        }
                    } catch (NoSuchElementException ex) {
                        System.out.println("NOT_FOUND");
                    }
                }
                case "add_new_astronaut" -> {
                    System.out.println("Enter astronaut's name:");
                    String astronautName = scanner.next();

                    System.out.println("Enter astronaut's year of birth:");
                    int yearOfBirth = scanner.nextInt();

                    try {
                        List<Spaceship> spaceshipList = spaceshipService.findAllSpaceships();
                        System.out.println("Available spaceships:");
                        for (int i = 0; i < spaceshipList.size(); i++) {
                            System.out.println((i + 1) + ". " + spaceshipList.get(i).getName());
                        }

                        System.out.println("Choose a spaceship by entering its number:");
                        int selectedSpaceshipIndex = scanner.nextInt();

                        if (selectedSpaceshipIndex > 0 && selectedSpaceshipIndex <= spaceshipList.size()) {
                            Spaceship selectedSpaceship = spaceshipList.get(selectedSpaceshipIndex - 1);

                            Astronaut newAstronaut = Astronaut.builder()
                                    .ID(UUID.randomUUID())
                                    .name(astronautName)
                                    .yearOfBirth(yearOfBirth)
                                    .spaceship(selectedSpaceship)
                                    .build();

                            astronautService.create(newAstronaut);
                            System.out.println("New astronaut added to the repository.");
                        } else {
                            System.out.println("Invalid spaceship selection.");
                        }
                    } catch (NoSuchElementException ex) {
                        System.out.println("NOT_FOUND");
                    }
                }
                case "delete_astronaut" -> {
                    try {
                        UUID uuid = UUID.fromString(scanner.next());
                        astronautService.delete(uuid);
                    } catch (NoSuchElementException ex) {
                        System.out.println("Not Found");
                    }
                }
                case "get_astronauts_by_spaceship_name" -> {
                    List<Spaceship> spaceshipList = spaceshipService.findAllSpaceships();
                    System.out.println("Available spaceships:");
                    for (int i = 0; i < spaceshipList.size(); i++) {
                        System.out.println((i + 1) + ". " + spaceshipList.get(i).getName());
                    }

                    System.out.println("Choose a spaceship by entering its number:");
                    int selectedSpaceshipIndex = scanner.nextInt();

                    if (selectedSpaceshipIndex > 0 && selectedSpaceshipIndex <= spaceshipList.size()) {
                        Spaceship selectedSpaceship = spaceshipList.get(selectedSpaceshipIndex - 1);
                        List<Astronaut> astronautsList = astronautService.findAstronautsBySpaceship(selectedSpaceship);
                        for (Astronaut astronaut:
                             astronautsList) {
                            System.out.println(astronaut);
                        }
                    }
                }
                case "quit" -> {
                    break main_loop;
                }
            }
        }
    }
}
