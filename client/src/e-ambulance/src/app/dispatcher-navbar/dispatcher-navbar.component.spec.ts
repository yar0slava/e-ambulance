import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DispatcherNavbarComponent } from './dispatcher-navbar.component';

describe('DispatcherNavbarComponent', () => {
  let component: DispatcherNavbarComponent;
  let fixture: ComponentFixture<DispatcherNavbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DispatcherNavbarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DispatcherNavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
