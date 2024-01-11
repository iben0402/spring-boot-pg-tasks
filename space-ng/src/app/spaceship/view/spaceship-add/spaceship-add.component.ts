import { Component, OnInit } from '@angular/core';
import { SpaceshipService } from '../../service/spaceship.service';
import { ActivatedRoute, Router } from '@angular/router';
import { SpaceshipForm } from '../../model/spaceship-form';
import { v4 as uuidv4 } from 'uuid';
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
   *
   * @param spaceshipService spaceship service
   * @param router router
   */
  constructor(
    private spaceshipService: SpaceshipService,
    private router: Router
  ) {
    this.spaceship = {
      name: '',
      capacity: 0
    };
  }
  ngOnInit() {

  }

  /**
   * adds spaceship.
   */
  onSubmit(): void {
    this.spaceshipService.putSpaceship(uuidv4(), this.spaceship!)
      .subscribe(() => this.router.navigate(['/spaceships']));
  }

}
