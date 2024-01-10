import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { NavComponent } from './component/nav/nav.component';
import { MainComponent } from './component/main/main.component';
import { HttpClientModule } from "@angular/common/http";
import { AstronautListComponent } from './astronaut/view/astronaut-list/astronaut-list.component';
import { AstronautService } from './astronaut/service/astronaut.service';
import { AstronautViewComponent } from './astronaut/view/astronaut-view/astronaut-view.component';
import { AstronautEditComponent } from './astronaut/view/astronaut-edit/astronaut-edit.component';
import { FormsModule } from "@angular/forms";
import { SpaceshipListComponent } from './spaceship/view/spaceship-list/spaceship-list.component';
import { SpaceshipEditComponent } from './spaceship/view/spaceship-edit/spaceship-edit.component';
import { SpaceshipViewComponent } from './spaceship/view/spaceship-view/spaceship-view.component';
import {SpaceshipService} from "./spaceship/service/spaceship.service";
import { SpaceshipAddComponent } from './spaceship/view/spaceship-add/spaceship-add.component';
import { AstronautAddComponent } from './astronaut/view/astronaut-add/astronaut-add.component';

/**
 * Application main module.
 */
@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    NavComponent,
    MainComponent,
    AstronautListComponent,
    AstronautViewComponent,
    AstronautEditComponent,
    SpaceshipListComponent,
    SpaceshipEditComponent,
    SpaceshipViewComponent,
    SpaceshipAddComponent,
    SpaceshipAddComponent,
    AstronautAddComponent,
    AstronautAddComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    AstronautService,
    SpaceshipService,
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule {

}
