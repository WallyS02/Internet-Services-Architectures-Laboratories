import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MusicianAddComponent } from './musician-add.component';

describe('AddComponent', () => {
  let component: MusicianAddComponent;
  let fixture: ComponentFixture<MusicianAddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MusicianAddComponent]
    });
    fixture = TestBed.createComponent(MusicianAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
