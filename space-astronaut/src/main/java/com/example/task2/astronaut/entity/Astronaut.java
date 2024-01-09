package com.example.task2.astronaut.entity;

import jakarta.persistence.*;
import lombok.*;
import com.example.task2.spaceship.entity.Spaceship;

import java.io.Serializable;
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
                ", spaceship: " + spaceship.getID() +
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
}
