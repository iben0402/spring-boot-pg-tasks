import { Component, OnInit } from '@angular/core';
import { AstronautService } from '../../service/astronaut.service';
import { ActivatedRoute, Router } from '@angular/router';
import { AstronautForm } from '../../model/astronaut-form';
import { SpaceshipService } from "../../../spaceship/service/spaceship.service";
import { Spaceships } from "../../../spaceship/model/spaceships";

@Component({
  selector: 'app-astronaut-edit',
  templateUrl: './astronaut-edit.component.html',
  styleUrls: ['./astronaut-edit.component.css']
})
export class AstronautEditComponent implements OnInit {

  /**
   * Astronaut's id.
   */
  uuid: string | undefined;

  /**
   * Single astronaut.
   */
  astronaut: AstronautForm | undefined;

  /**
   * Single astronaut.
   */
  original: AstronautForm | undefined;

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
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.spaceshipService.getSpaceships()
        .subscribe(spaceships => this.spaceships = spaceships);

      this.astronautService.getAstronaut(params['uuid'])
        .subscribe(astronaut => {
          this.uuid = astronaut.id;
          this.astronaut = {
            name: astronaut.name,
            yearOfBirth: astronaut.yearOfBirth,
            spaceship: astronaut.spaceship.id
          };
          this.original = {...this.astronaut};
        });
    });
  }

  /**
   * Updates astronaut.
   */
  onSubmit(): void {
    this.astronautService.putAstronaut(this.uuid!, this.astronaut!)
      .subscribe(() => this.router.navigate(['/astronauts']));
  }

}
