import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MusicianEditComponent } from './musician-edit.component';

describe('EditComponent', () => {
  let component: MusicianEditComponent;
  let fixture: ComponentFixture<MusicianEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MusicianEditComponent]
    });
    fixture = TestBed.createComponent(MusicianEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
