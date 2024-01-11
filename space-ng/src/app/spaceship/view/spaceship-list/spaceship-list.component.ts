import { Component, OnInit } from '@angular/core';
import { SpaceshipService } from "../../service/spaceship.service";
import { Spaceships } from "../../model/spaceships";
import { Spaceship } from "../../model/spaceship";

@Component({
  selector: 'app-spaceship-list',
  templateUrl: './spaceship-list.component.html',
  styleUrls: ['./spaceship-list.component.css']
})
export class SpaceshipListComponent {

  /**
   * @param service spaceship service
   */
  constructor(private service: SpaceshipService) {
  }

  /**
   * Available spaceships.
   */
  spaceships: Spaceships | undefined;

  ngOnInit(): void {
    this.service.getSpaceships().subscribe(spaceships => this.spaceships = spaceships);
  }

  /**
   * Deletes selected spaceship.
   *
   * @param spaceship spaceship to be removed
   */
  onDelete(spaceship: Spaceship): void {
    this.service.deleteSpaceship(spaceship.id).subscribe(() => this.ngOnInit());
  }

}
