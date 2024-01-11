import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AstronautAddComponent } from './astronaut-add.component';

describe('AstronautAddComponent', () => {
  let component: AstronautAddComponent;
  let fixture: ComponentFixture<AstronautAddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AstronautAddComponent]
    });
    fixture = TestBed.createComponent(AstronautAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
