package com.example.task2.serialization;

import com.example.task2.spaceship.Spaceship;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class SerializationHelper {
    public static void serializespaceships(List<Spaceship> spaceships, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(spaceships);
            System.out.println("Serialization successful. Saved to " + filename);
        } catch (IOException e) {
            System.err.println("Error during serialization: " + e.getMessage());
        }
    }

    public static List<Spaceship> deserializespaceships(String filename) {
        List<Spaceship> spaceships = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            spaceships = (List<Spaceship>) ois.readObject();
            System.out.println("Deserialization successful. Loaded from " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error during deserialization: " + e.getMessage());
        }
        return spaceships;
    }
}
