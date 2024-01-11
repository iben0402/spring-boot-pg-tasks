import { Component, OnInit } from '@angular/core';
import { SpaceshipService } from "../../service/spaceship.service";
import { ActivatedRoute, Router } from "@angular/router";
import { SpaceshipDetails } from "../../model/spaceship-details";
import {Astronaut} from "../../../astronaut/model/astronaut";

/**
 * Preview of single astronaut.
 */
@Component({
  selector: 'app-spaceship-view',
  templateUrl: './spaceship-view.component.html',
  styleUrls: ['./spaceship-view.component.css']
})
export class SpaceshipViewComponent implements OnInit {

  /**
   * Single spaceship.
   */
  spaceship: SpaceshipDetails | undefined;
  astronauts: any;

  /**
   *
   * @param service spaceship service
   * @param route activated route
   * @param router router
   */
  constructor(private spaceshipService: SpaceshipService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.spaceshipService.getSpaceship(params['uuid'])
        .subscribe(spaceship => this.spaceship = spaceship);
      this.spaceshipService.getSpaceshipAstronauts(params['uuid']).subscribe(astronauts => this.astronauts = astronauts);
    });
  }

  onDelete(astronaut: Astronaut): void {
    this.spaceshipService.deleteAstronaut(astronaut.id).subscribe(() => this.ngOnInit());
  }

}
