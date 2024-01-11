import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Astronauts } from "../model/astronauts";
import { AstronautDetails } from "../model/astronaut-details";
import { AstronautForm } from "../model/astronaut-form";

/**
 * Astronaut management service. Calls REST endpoints.
 */
@Injectable()
export class AstronautService {

  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {

  }

  /**
   * Fetches all astronauts.
   *
   * @return list of astronauts
   */
  getAstronauts(): Observable<Astronauts> {
    return this.http.get<Astronauts>('/api/astronauts');
  }

  /**
   * Fetches single astronaut.
   *
   * @param uuid astronaut's id
   * @return single astronaut
   */
  getAstronaut(uuid: string): Observable<AstronautDetails> {
    return this.http.get<AstronautDetails>('/api/astronauts/' + uuid);
  }

  /**
   * Removes single astronaut.
   *
   * @param uuid astronaut's id
   */
  deleteAstronaut(uuid: string): Observable<any> {
    return this.http.delete('/api/astronauts/' + uuid);
  }

  /**
   * Updates single astronaut.
   *
   * @param uuid astronaut's id
   * @param request request body
   */
  putAstronaut(uuid: string, request: AstronautForm): Observable<any> {
    return this.http.put('/api/astronauts/' + uuid, request);
  }

}
