import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrewCallsListComponent } from './crew-calls-list.component';

describe('CrewCallsListComponent', () => {
  let component: CrewCallsListComponent;
  let fixture: ComponentFixture<CrewCallsListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrewCallsListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrewCallsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
