import { MockBackend } from '@angular/http/testing';
import { Http, BaseRequestOptions } from '@angular/http';
import { TestBed, inject } from '@angular/core/testing';

import { TrackService } from './track.service';

describe('TrackService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        TrackService,
        MockBackend,
        BaseRequestOptions,
        {
          provide: Http,
          deps: [MockBackend, BaseRequestOptions],
          useFactory:
            (backend, defaultOptions) => {
                return new Http(backend, defaultOptions);
            }
         }
      ]
    });
  });

  it('should ...', inject([TrackService], (service: TrackService) => {
    expect(service).toBeTruthy();
  }));
});
