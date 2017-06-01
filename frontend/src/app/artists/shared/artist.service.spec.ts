import { MockBackend } from '@angular/http/testing';
import { Http, BaseRequestOptions } from '@angular/http';
import { TestBed, inject } from '@angular/core/testing';

import { ArtistService } from './artist.service';

describe('ArtistService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        ArtistService,
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

  it('should ...', inject([ArtistService], (service: ArtistService) => {
    expect(service).toBeTruthy();
  }));
});
