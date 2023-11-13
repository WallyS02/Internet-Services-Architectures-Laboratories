import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstrumentAddComponent } from './instrument-add.component';

describe('AddComponent', () => {
  let component: InstrumentAddComponent;
  let fixture: ComponentFixture<InstrumentAddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [InstrumentAddComponent]
    });
    fixture = TestBed.createComponent(InstrumentAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
