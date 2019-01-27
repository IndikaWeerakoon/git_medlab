import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LabTesterComponent } from './lab-tester.component';

describe('LabTesterComponent', () => {
  let component: LabTesterComponent;
  let fixture: ComponentFixture<LabTesterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LabTesterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LabTesterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
