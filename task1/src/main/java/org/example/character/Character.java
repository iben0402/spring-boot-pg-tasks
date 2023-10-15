package org.example.character;

import lombok.*;
import org.example.profession.Profession;
import java.io.Serializable;

import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Character implements Comparable<Character>, Serializable{
    private String name;
    private int health;
    private Profession profession;

    @Override
    public String toString() {
        return "Character{" +
                "name: '" + name + '\'' +
                ", health: " + health +
                ", profession: " + profession.getName() +
                '}';
    }

    @Override
    public int compareTo(Character o) {
        if (this.name.compareTo(o.getName()) != 0) {
            return this.name.compareTo(o.getName());
        } else if(this.profession.compareTo(o.getProfession()) != 0){
            return this.profession.compareTo(o.getProfession());
        } else {
            return Integer.compare(this.health, o.getHealth());
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health, profession);
    }

    public static class CharacterBuilder {
        private int health = 100;  // Default health value

        public CharacterBuilder health(int health) {
            if (health < 0) {
                throw new IllegalArgumentException("Health cannot be negative.");
            }
            this.health = health;
            return this;
        }

        public CharacterBuilder profession(Profession profession) {
            // Set the profession for the character
            this.profession = profession;

            // Add the current character to the profession's characters list
            if (profession != null) {
                profession.addCharacter(build());
            }

            return this;
        }

        public Character build() {
            if (name == null || name.isEmpty()) {
                throw new IllegalStateException("Character name cannot be null or empty.");
            }
            return new Character(name, health, profession);
        }
    }
}
