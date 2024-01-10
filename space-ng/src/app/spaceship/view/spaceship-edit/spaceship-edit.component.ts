import { Component, OnInit } from '@angular/core';
import { SpaceshipService } from '../../service/spaceship.service';
import { ActivatedRoute, Router } from '@angular/router';
import { SpaceshipForm } from '../../model/spaceship-form';
import {Astronauts} from "../../../astronaut/model/astronauts";
import {AstronautService} from "../../../astronaut/service/astronaut.service";

@Component({
  selector: 'app-spaceship-edit',
  templateUrl: './spaceship-edit.component.html',
  styleUrls: ['./spaceship-edit.component.css']
})
export class SpaceshipEditComponent implements OnInit {

  /**
   * Spaceship's id.
   */
  uuid: string | undefined;

  /**
   * Single spaceship.
   */
  spaceship: SpaceshipForm | undefined;

  /**
   * Single spaceship.
   */
  original: SpaceshipForm | undefined;

  /**
   * Available astronauts.
   */
  astronauts: Astronauts | undefined;

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
      this.spaceshipService.getSpaceship(params['uuid'])
        .subscribe(spaceship => {
          this.uuid = spaceship.id;
          this.spaceship = {
            name: spaceship.name,
            capacity: spaceship.capacity,
          };
          this.original = {...this.spaceship};
        });
    });
  }

  /**
   * Updates spaceship.
   */
  onSubmit(): void {
    this.spaceshipService.putSpaceship(this.uuid!, this.spaceship!)
      .subscribe(() => this.router.navigate(['/spaceship']));
  }

}
