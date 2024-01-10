import { Component, OnInit } from '@angular/core';
import { AstronautService } from '../../service/astronaut.service';
import { ActivatedRoute, Router } from '@angular/router';
import { AstronautForm } from '../../model/astronaut-form';
import { SpaceshipService } from "../../../spaceship/service/spaceship.service";
import { Spaceships } from "../../../spaceship/model/spaceships";
import {Spaceship} from "../../../spaceship/model/spaceship";
import { v4 as uuidv4 } from 'uuid';
import {Astronauts} from "../../model/astronauts";

@Component({
  selector: 'app-astronaut-add',
  templateUrl: './astronaut-add.component.html',
  styleUrls: ['./astronaut-add.component.css']
})
export class AstronautAddComponent implements OnInit {

  /**
   * Astronaut's id.
   */
  uuid: string | undefined;

  /**
   * Single astronaut.
   */
  astronaut: AstronautForm;

  /**
   * Single spaceship.
   */
  spaceship: Spaceship | undefined;

  /**
   * Available spaceships.
   */
  spaceships: Spaceships | undefined;

  /**
   * @param astronautService astronaut service
   * @param spaceshipService spaceship service
   * @param route activated route
   * @param router router
   */
  constructor(
    private astronautService: AstronautService,
    private spaceshipService: SpaceshipService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.astronaut = {
      name:'',
      yearOfBirth: 0,
      spaceship: '',
    }
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.spaceshipService.getSpaceships()
        .subscribe(spaceships => this.spaceships = spaceships);
    });

    this.route.params.subscribe(params => {
      this.spaceshipService.getSpaceship(params['uuid'])
        .subscribe(spaceship => {
          this.generateUUID().then(generatedUUID => {
            this.uuid = generatedUUID;
          });
          this.spaceship = {
            id: spaceship.id,
            name: spaceship.name,
            capacity: spaceship.capacity,
          };
          this.astronaut.spaceship = this.spaceship.id;
        });
    });


    this.uuid = 'f5875513-bf7b-4ae1-b8a5-5b70a1b90333';
  }

  /**
   * Updates astronaut.
   */
  onSubmit(): void {
    this.astronautService.putAstronaut(this.uuid!, this.astronaut!)
      .subscribe(() => this.router.navigate(['/astronauts']));
  }


  async generateUUID(): Promise<string> {
    let uniqueUUID = uuidv4();
    let isUnique = false;

    while (!isUnique) {
      this.astronautService.getAstronaut(uniqueUUID).subscribe(astronaut => {
        if (astronaut.id === uniqueUUID) {
          isUnique = false;
        } else {
          isUnique = true;
        }
      });
    }

    return uniqueUUID;
  }


}
