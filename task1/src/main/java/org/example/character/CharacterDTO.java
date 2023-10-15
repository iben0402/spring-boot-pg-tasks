package org.example.character;


import lombok.*;

@Builder
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
public class CharacterDTO implements Comparable<CharacterDTO>{
    private String name;
    private int health;
    private String profession;

    @Override
    public String toString() {
        return "CharacterDTO{" +
                "name: '" + name + '\'' +
                ", health: " + health +
                ", profession: " + profession +
                '}';
    }


    @Override
    public int compareTo(CharacterDTO o) {
        if (this.name.compareTo(o.getName()) != 0) {
            return this.name.compareTo(o.getName());
        } else if(this.profession.compareTo(o.getProfession()) != 0){
            return this.profession.compareTo(o.getProfession());
        } else {
            return Integer.compare(this.health, o.getHealth());
        }
    }
}
