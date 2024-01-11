import { Component, OnInit } from '@angular/core';
import { AstronautService } from "../../service/astronaut.service";
import { ActivatedRoute, Router } from "@angular/router";
import { AstronautDetails } from "../../model/astronaut-details";

/**
 * Preview of single astronaut.
 */
@Component({
  selector: 'app-astronaut-view',
  templateUrl: './astronaut-view.component.html',
  styleUrls: ['./astronaut-view.component.css']
})
export class AstronautViewComponent implements OnInit {

  /**
   * Single astronaut.
   */
  astronaut: AstronautDetails | undefined;

  /**
   *
   * @param service astronaut service
   * @param route activated route
   * @param router router
   */
  constructor(private service: AstronautService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getAstronaut(params['uuid'])
        .subscribe(astronaut => this.astronaut = astronaut)
    });
  }

}
