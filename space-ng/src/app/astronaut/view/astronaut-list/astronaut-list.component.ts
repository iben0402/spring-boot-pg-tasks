import { Component, OnInit } from '@angular/core';
import { AstronautService } from "../../service/astronaut.service";
import { Astronauts } from "../../model/astronauts";
import { Astronaut } from "../../model/astronaut";

@Component({
  selector: 'app-astronaut-list',
  templateUrl: './astronaut-list.component.html',
  styleUrls: ['./astronaut-list.component.css']
})
export class AstronautListComponent implements OnInit{

  /**
   * @param service astronauts service
   */
  constructor(private service: AstronautService) {
  }

  /**
   * Available astronauts.
   */
  astronauts: Astronauts | undefined;

  ngOnInit(): void {
    this.service.getAstronauts().subscribe(astronauts => this.astronauts = astronauts);
  }

  /**
   * Deletes selected astronaut.
   *
   * @param astronaut astronaut to be removed
   */
  onDelete(astronaut: Astronaut): void {
    this.service.deleteAstronaut(astronaut.id).subscribe(() => this.ngOnInit());
  }

}
