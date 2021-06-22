import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterCrewComponent } from './register-crew.component';

describe('RegisterCrewComponent', () => {
  let component: RegisterCrewComponent;
  let fixture: ComponentFixture<RegisterCrewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisterCrewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterCrewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
