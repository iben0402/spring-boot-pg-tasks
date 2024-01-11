import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpaceshipEditComponent } from './spaceship-edit.component';

describe('SpaceshiptEditComponent', () => {
  let component: SpaceshipEditComponent;
  let fixture: ComponentFixture<SpaceshipEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SpaceshipEditComponent]
    });
    fixture = TestBed.createComponent(SpaceshipEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
