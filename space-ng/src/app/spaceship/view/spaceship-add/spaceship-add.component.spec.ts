import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpaceshipAddComponent } from './spaceship-add.component';

describe('SpaceshipAddComponent', () => {
  let component: SpaceshipAddComponent;
  let fixture: ComponentFixture<SpaceshipAddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SpaceshipAddComponent]
    });
    fixture = TestBed.createComponent(SpaceshipAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
