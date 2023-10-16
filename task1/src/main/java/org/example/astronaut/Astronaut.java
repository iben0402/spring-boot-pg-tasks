package org.example.astronaut;

import lombok.*;
import org.example.spaceship.Spaceship;

import java.io.Serializable;

import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Astronaut implements Comparable<Astronaut>, Serializable{
    private String name;
    private int yearOfBirth;
    private Spaceship spaceship;

    @Override
    public String toString() {
        return "Astronaut{" +
                "name: '" + name + '\'' +
                ", year of birth: " + yearOfBirth +
                ", spaceship: " + spaceship.getName() +
                '}';
    }

    @Override
    public int compareTo(Astronaut o) {
        if (this.name.compareTo(o.getName()) != 0) {
            return this.name.compareTo(o.getName());
        } else if(this.spaceship.compareTo(o.getSpaceship()) != 0){
            return this.spaceship.compareTo(o.getSpaceship());
        } else {
            return Integer.compare(this.yearOfBirth, o.getYearOfBirth());
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yearOfBirth, spaceship);
    }

    public static class AstronautBuilder {

        public Astronaut build() {
            if (name == null || name.isEmpty()) {
                throw new IllegalStateException("Astronaut name cannot be null or empty.");
            }
            if(yearOfBirth == 0) {
                throw new IllegalStateException("Astronaut year of birth test cannot be null.");
            }
            if (spaceship == null) {
                throw new IllegalStateException("Astronaut spaceship cannot be null.");
            }
            Astronaut tempAstronaut = new Astronaut(name, yearOfBirth, spaceship);
            spaceship.addAstronaut(tempAstronaut);
            return tempAstronaut;
        }
    }
}
