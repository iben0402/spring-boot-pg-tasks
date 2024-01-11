import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpaceshipListComponent } from './spaceship-list.component';

describe('SpaceshipListComponent', () => {
  let component: SpaceshipListComponent;
  let fixture: ComponentFixture<SpaceshipListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SpaceshipListComponent]
    });
    fixture = TestBed.createComponent(SpaceshipListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
