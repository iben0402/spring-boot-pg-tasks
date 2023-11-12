package com.example.task2.astronaut.entity;

import jakarta.persistence.*;
import lombok.*;
import com.example.task2.spaceship.entity.Spaceship;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@Entity
@Table(name = "astronauts")
public class Astronaut implements Comparable<Astronaut>, Serializable{
    @Id
    private UUID ID;
    private String name;
    private int yearOfBirth;
    @ManyToOne
    @JoinColumn(name = "spaceship_id")
    private Spaceship spaceship;

    @Override
    public String toString() {
        return "Astronaut{" +
                "ID: " + ID +
                ", name: '" + name + '\'' +
                ", year of birth: " + yearOfBirth +
                ", spaceship: " + spaceship.getName() +
                '}';
    }

    @Override
    public int compareTo(Astronaut o) {
        if(this.ID.compareTo(o.getID()) != 0) {
            return this.ID.compareTo(o.getID());
        } else if (this.name.compareTo(o.getName()) != 0) {
            return this.name.compareTo(o.getName());
        } else if(this.spaceship.compareTo(o.getSpaceship()) != 0){
            return this.spaceship.compareTo(o.getSpaceship());
        } else {
            return Integer.compare(this.yearOfBirth, o.getYearOfBirth());
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, yearOfBirth, spaceship);
    }

    public static class AstronautBuilder {

        public Astronaut build() {
            if (ID == null) {
                throw new IllegalStateException("Astronaut ID cannot be null or empty.");
            }
            if (name == null || name.isEmpty()) {
                throw new IllegalStateException("Astronaut name cannot be null or empty.");
            }
            if(yearOfBirth == 0) {
                throw new IllegalStateException("Astronaut year of birth test cannot be null.");
            }
            if (spaceship == null) {
                throw new IllegalStateException("Astronaut spaceship cannot be null.");
            }
            Astronaut tempAstronaut = new Astronaut(ID, name, yearOfBirth, spaceship);
            spaceship.addAstronaut(tempAstronaut);
            return tempAstronaut;
        }
    }
}
