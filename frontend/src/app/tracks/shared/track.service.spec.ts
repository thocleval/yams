import { TestBed, inject } from '@angular/core/testing';

import { TrackService } from './track.service';

describe('TrackService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TrackService]
    });
  });

  it('should ...', inject([TrackService], (service: TrackService) => {
    expect(service).toBeTruthy();
  }));
});
