import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DispatcherInfoComponent } from './dispatcher-info.component';

describe('DispatcherInfoComponent', () => {
  let component: DispatcherInfoComponent;
  let fixture: ComponentFixture<DispatcherInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DispatcherInfoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DispatcherInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
