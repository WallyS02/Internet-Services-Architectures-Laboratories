import { TestBed } from '@angular/core/testing';

import { InstrumentService } from './instrument.service';

describe('ServiceService', () => {
  let service: InstrumentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InstrumentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
