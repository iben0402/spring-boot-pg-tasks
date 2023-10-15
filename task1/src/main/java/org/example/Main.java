package org.example;

import org.example.character.Character;
import org.example.character.CharacterDTO;
import org.example.profession.Profession;
import org.example.serialization.SerializationHelper;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // -------------Create professions----------------
        Profession warrior = Profession.builder()
                .name("Warrior")
                .baseArmor(10)
                .characters(new ArrayList<>())
                .build();

        Profession mage = Profession.builder()
                .name("Mage")
                .baseArmor(5)
                .characters(new ArrayList<>())
                .build();

        Profession rogue = Profession.builder()
                .name("Rogue")
                .baseArmor(7)
                .characters(new ArrayList<>())
                .build();
        // -------------------------------------------------


        // ----------------Create characters----------------
        Character characterWarrior1 = Character.builder()
                .name("Bob")
                .health(100)
                .profession(warrior)
                .build();

        Character characterWarrior2 = Character.builder()
                .name("John")
                .health(90)
                .profession(warrior)
                .build();

        Character characterMage1 = Character.builder()
                .name("Alice")
                .health(80)
                .profession(mage)
                .build();

        Character characterMage2 = Character.builder()
                .name("Eve")
                .health(80)
                .profession(mage)
                .build();

        Character characterRogue1 = Character.builder()
                .name("Eve")
                .health(70)
                .profession(rogue)
                .build();

        Character characterRogue2 = Character.builder()
                .name("Alex")
                .health(70)
                .profession(rogue)
                .build();

        Character characterRogue3 = Character.builder()
                .name("Peter")
                .health(70)
                .profession(rogue)
                .build();

        // -------------------------------------------------

        // -----------------Add characters and professions to lists------------------
        List<Profession> professions = Arrays.asList(warrior, mage, rogue);
        List<Character> allCharacters = Arrays.asList(
                characterWarrior1, characterWarrior2,
                characterMage1, characterMage2,
                characterRogue1, characterRogue2, characterRogue3
        );

        // -------------------------------------------------

        // -----------------Print all professions and characters in original order------------------
        System.out.println("All professions in original order:");
        professions.forEach(profession -> {
            System.out.println(profession);
        });
        System.out.println();

        System.out.println("All characters in original order:");
        allCharacters.forEach(character -> {
            System.out.println(character);
        });
        System.out.println();
        // -------------------------------------------------

        // -----------------Create set of all characters-------------------------------
        Set<Character> allCharactersSet = professions.stream()
                .flatMap(profession -> profession.getCharacters().stream())
                .collect(Collectors.toSet());

        System.out.println("All characters in set:");
        allCharactersSet.stream().forEach(System.out::println);
        System.out.println();
        //-----------------------------------------------------------------------------

        //-----------------Filter by profession name-------------------------------
        System.out.println("All characters with profession name 'Warrior':");
        allCharactersSet.stream()
                .filter(character -> character.getProfession().getName().equals("Warrior"))
                .forEach(System.out::println);
        System.out.println();
        //-----------------------------------------------------------------------------

        //-----------------Sort by name------------------------------------------------
        System.out.println("All characters sorted by name:");
        allCharactersSet.stream()
                .sorted(Comparator.comparing(Character::getName))
                .forEach(System.out::println);
        System.out.println();
        //-----------------------------------------------------------------------------

        //-----------------map to DTO objects and sort using natural order------------------------------------------
        List<CharacterDTO> characterDTOs = allCharactersSet.stream()
                .map(character -> CharacterDTO.builder()
                        .name(character.getName())
                        .health(character.getHealth())
                        .profession(character.getProfession().getName())
                        .build())
                .sorted()
                .toList();

        System.out.println("All characters mapped to DTO objects and sorted using natural order:");
        characterDTOs.stream()
                .forEach(System.out::println);
        System.out.println();
        //-----------------------------------------------------------------------------

        //-----------------Serialization and deserialization------------------------------------------
        SerializationHelper.serializeProfessions(professions, "professions.ser");

        List<Profession> deserializedProfessions = SerializationHelper.deserializeProfessions("professions.ser");
        System.out.println("All professions deserialized from professions.ser:");
        deserializedProfessions.stream()
                .forEach(System.out::println);

        System.out.println();
        //-----------------------------------------------------------------------------

        //-----------------Parallel stream------------------------------------------
        System.out.println("All characters in parallel stream:");
        ForkJoinPool customThreadPool = new ForkJoinPool(4);  // Adjust pool size as needed

        // Task: Print elements with intervals
        Runnable printTask = () -> {
            try {
                // Print each character in the category with a delay
                for (Character character : allCharacters) {
                    System.out.println("Profession: " + character.getProfession().getName() + ", Character: " + character.getName());
                    Thread.sleep(100);  // Simulate workload
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // Execute the task for each category using parallel streams and custom thread pool
        professions.stream()
                .parallel()
                .forEach(profession -> customThreadPool.execute(printTask));

        customThreadPool.shutdown();

    }
}