package org.example.spaceship;
import lombok.*;
import org.example.astronaut.Astronaut;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Spaceship implements Comparable<Spaceship>, Serializable {
    private String name;
    private int capacity;
    private List<Astronaut> astronauts;

    public void addAstronaut(Astronaut astronaut) {
        astronauts.add(astronaut);
        astronaut.setSpaceship(this);
    }

    public void removeAstronaut(Astronaut astronaut) {
        astronauts.remove(astronaut);
        astronaut.setSpaceship(null);
    }

    @Override
    public String toString() {
        String charactersString = "";
        for (Astronaut astronaut : astronauts) {
            charactersString += astronaut.getName() + ", ";
        }
        return "Spaceship{" +
                "name: '" + name + '\'' +
                ", capacity: " + capacity +
                ", astronauts: " + charactersString +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capacity);
    }
    @Override
    public int compareTo(Spaceship o) {
        if(this.name.compareTo(o.getName()) != 0){
            return this.name.compareTo(o.getName());
        } else {
            return Integer.compare(this.capacity, o.getCapacity());
        }
    }
}
