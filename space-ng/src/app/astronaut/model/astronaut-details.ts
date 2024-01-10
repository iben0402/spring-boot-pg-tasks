import { Spaceship } from "../../spaceship/model/spaceship";

/**
 * Represents single astronaut in list.
 */
export interface AstronautDetails {

  /**
   * Unique id identifying astronaut.
   */
  id: string;

  /**
   * Name of the astronaut.
   */
  name: string;

  /**
   * Astronaut's year of birth.
   */
  yearOfBirth: number;

  /**
   * Astronaut's spaceship.
   */
  spaceship: Spaceship;
}
