import { Astronaut } from "./astronaut";

/**
 * GET astronautss response. Contains list of available astronauts. Can be used to list particular user's astronauts as
 * well as all astronauts in the game.
 */
export interface Astronauts {

  /**
   * Name of the selected astronauts.
   */
  astronauts:Astronaut[];

}
