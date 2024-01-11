import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AstronautViewComponent } from './astronaut-view.component';

describe('AstronautViewComponent', () => {
  let component: AstronautViewComponent;
  let fixture: ComponentFixture<AstronautViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AstronautViewComponent]
    });
    fixture = TestBed.createComponent(AstronautViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
