import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MusicianDetailComponent } from './musician-detail.component';

describe('DetailComponent', () => {
  let component: MusicianDetailComponent;
  let fixture: ComponentFixture<MusicianDetailComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MusicianDetailComponent]
    });
    fixture = TestBed.createComponent(MusicianDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
