import { Component, OnInit } from '@angular/core';
import { SpaceshipService } from '../../service/spaceship.service';
import { ActivatedRoute, Router } from '@angular/router';
import { SpaceshipForm } from '../../model/spaceship-form';
import {Astronauts} from "../../../astronaut/model/astronauts";
import {AstronautService} from "../../../astronaut/service/astronaut.service";

@Component({
  selector: 'app-spaceship-add',
  templateUrl: './spaceship-add.component.html',
  styleUrls: ['./spaceship-add.component.css']
})
export class SpaceshipAddComponent implements OnInit {

  /**
   * Spaceship's id.
   */
  uuid: string | undefined;

  /**
   * Single spaceship.
   */
  spaceship: SpaceshipForm | undefined;

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
    this.spaceship = {
      name: '',
      capacity: 0
    }
  }

  /**
   * Updates spaceship.
   */
  onSubmit(): void {
    this.spaceshipService.putSpaceship(this.uuid!, this.spaceship!)
      .subscribe(() => this.router.navigate(['/spaceships']));
  }

}
