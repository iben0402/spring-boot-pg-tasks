import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AstronautListComponent } from "./astronaut/view/astronaut-list/astronaut-list.component";
import { AstronautViewComponent } from "./astronaut/view/astronaut-view/astronaut-view.component";
import { AstronautEditComponent } from "./astronaut/view/astronaut-edit/astronaut-edit.component";
import {SpaceshipListComponent} from "./spaceship/view/spaceship-list/spaceship-list.component";
import {SpaceshipViewComponent} from "./spaceship/view/spaceship-view/spaceship-view.component";
import {SpaceshipEditComponent} from "./spaceship/view/spaceship-edit/spaceship-edit.component";

/**
 * All available routes.
 */
const routes: Routes = [
  {
    component: AstronautListComponent,
    path: "astronauts"
  },
  {
    component: AstronautViewComponent,
    path: "astronauts/:uuid"
  }
  ,
  {
    component: AstronautEditComponent,
    path: "astronauts/:uuid/edit"
  }
  ,
  {
    component: SpaceshipListComponent,
    path: "spaceships"
  },
  {
    component: SpaceshipViewComponent,
    path: "spaceships/:uuid"
  }
  ,
  {
    component: SpaceshipEditComponent,
    path: "spaceships/:uuid/edit"
  }
];

/**
 * Global routing module.
 */
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
