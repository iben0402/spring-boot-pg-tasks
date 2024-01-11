import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpaceshipViewComponent } from './spaceship-view.component';

describe('SpaceshipViewComponent', () => {
  let component: SpaceshipViewComponent;
  let fixture: ComponentFixture<SpaceshipViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SpaceshipViewComponent]
    });
    fixture = TestBed.createComponent(SpaceshipViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
