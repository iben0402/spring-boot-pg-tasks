import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Spaceships } from "../model/spaceships";
import {Spaceship} from "../model/spaceship";
import {SpaceshipForm} from "../model/spaceship-form";
import {SpaceshipDetails} from "../model/spaceship-details";
import {Astronauts} from "../../astronaut/model/astronauts";

/**
 * Spaceship management service. Calls REST endpoints.
 */
@Injectable({
  providedIn: 'root'
})
export class SpaceshipService {

  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {

  }

  /**
   * Fetches all spaceships.
   *
   * @return list of spaceships
   */
  getSpaceships(): Observable<Spaceships> {
    return this.http.get<Spaceships>('/api/spaceships');
  }

  deleteSpaceship(uuid: string) {
    return this.http.delete('/api/spaceships/' + uuid);
  }

  getSpaceship(uuid: string) {
    return this.http.get<SpaceshipDetails>('/api/spaceships/' + uuid);
  }

  putSpaceship(uuid: string, spaceshipForm: SpaceshipForm) {
    return this.http.put('/api/spaceships/' + uuid, spaceshipForm);
  }

  getSpaceshipAstronauts(uuid: string) {
    return this.http.get<Astronauts>('/api/spaceships/' + uuid + '/astronauts');
  }

  deleteAstronaut(uuid: string): Observable<any> {
    return this.http.delete('/api/astronauts/' + uuid);
  }
}
