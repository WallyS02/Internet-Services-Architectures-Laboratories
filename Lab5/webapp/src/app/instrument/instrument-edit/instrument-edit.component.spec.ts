import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstrumentEditComponent } from './instrument-edit.component';

describe('EditComponent', () => {
  let component: InstrumentEditComponent;
  let fixture: ComponentFixture<InstrumentEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [InstrumentEditComponent]
    });
    fixture = TestBed.createComponent(InstrumentEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
