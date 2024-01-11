import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AstronautEditComponent } from './astronaut-edit.component';

describe('AstronautEditComponent', () => {
  let component: AstronautEditComponent;
  let fixture: ComponentFixture<AstronautEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AstronautEditComponent]
    });
    fixture = TestBed.createComponent(AstronautEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
