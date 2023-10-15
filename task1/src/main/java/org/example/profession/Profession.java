package org.example.profession;
import lombok.*;
import org.example.character.Character;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Profession implements Comparable<Profession>, Serializable {
    private String name;
    private int baseArmor;
    private List<Character> characters;

    public void addCharacter(Character character) {
        characters.add(character);
        character.setProfession(this);
    }

    public void removeCharacter(Character character) {
        characters.remove(character);
        character.setProfession(null);
    }

    @Override
    public String toString() {
        String charactersString = "";
        for (Character character : characters) {
            charactersString += character.getName() + ", ";
        }
        return "Profession{" +
                "name: '" + name + '\'' +
                ", baseArmor: " + baseArmor +
                ", characters: " + charactersString +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, baseArmor);
    }
    @Override
    public int compareTo(Profession o) {
        if(this.name.compareTo(o.getName()) != 0){
            return this.name.compareTo(o.getName());
        } else {
            return Integer.compare(this.baseArmor, o.getBaseArmor());
        }
    }
}
