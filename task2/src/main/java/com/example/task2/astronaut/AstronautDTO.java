package com.example.task2.astronaut;


import lombok.*;

@Builder
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
public class AstronautDTO implements Comparable<AstronautDTO>{
    private String name;

    @Override
    public String toString() {
        return "AstronautDTO{" +
                "name: '" + name + '\'' + '}';
    }


    @Override
    public int compareTo(AstronautDTO o) {
        return this.name.compareTo(o.getName());
    }

    public AstronautDTO(Astronaut astronaut) {
        this.name = astronaut.getName();
    }
}
