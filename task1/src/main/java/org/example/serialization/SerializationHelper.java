package org.example.serialization;

import org.example.profession.Profession;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class SerializationHelper {
    public static void serializeProfessions(List<Profession> professions, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(professions);
            System.out.println("Serialization successful. Saved to " + filename);
        } catch (IOException e) {
            System.err.println("Error during serialization: " + e.getMessage());
        }
    }

    public static List<Profession> deserializeProfessions(String filename) {
        List<Profession> professions = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            professions = (List<Profession>) ois.readObject();
            System.out.println("Deserialization successful. Loaded from " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error during deserialization: " + e.getMessage());
        }
        return professions;
    }
}
