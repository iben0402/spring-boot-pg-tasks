import { Astronauts } from "../../astronaut/model/astronauts";

/**
 * Represents single Spaceship in list.
 */
export interface SpaceshipDetails {

  /**
   * Unique id identifying spaceship.
   */
  id: string;

  /**
   * Name of the spaceship.
   */
  name: string;

  /**
   * Spaceship's capacity.
   */
  capacity: number;

}
