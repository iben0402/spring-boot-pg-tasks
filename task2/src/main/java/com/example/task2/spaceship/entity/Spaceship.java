package com.example.task2.spaceship.entity;
import jakarta.persistence.*;
import lombok.*;
import com.example.task2.astronaut.entity.Astronaut;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@NoArgsConstructor
@Entity
@Table(name = "spaceships")
public class Spaceship implements Comparable<Spaceship>, Serializable {
    @Id
    private UUID ID;
    private String name;
    private int capacity;
    @OneToMany(mappedBy = "spaceship", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
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
    public int compareTo(Spaceship o) {
        if(this.ID.compareTo(o.getID()) != 0) {
            return this.ID.compareTo(o.getID());
        } else if(this.name.compareTo(o.getName()) != 0){
            return this.name.compareTo(o.getName());
        } else {
            return Integer.compare(this.capacity, o.getCapacity());
        }
    }
}
