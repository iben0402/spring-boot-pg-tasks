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
    @OneToMany(mappedBy = "spaceship", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Astronaut> astronauts;

    @Override
    public int compareTo(Spaceship o) {
        return this.ID.compareTo(o.getID());
    }
}
