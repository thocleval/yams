import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { ApiService } from './../../shared/api.service';
import { Artist } from './artist';
import { Injectable } from '@angular/core';

import { ApiInterface } from '../../shared/api-interface';

import 'rxjs/add/operator/toPromise';


@Injectable()
export class ArtistService implements ApiInterface<Artist> {
  artistsUrl = 'api/artist/';
  private apiService: ApiService<Artist>;

  constructor(http: Http) {
    this.apiService = new ApiService(http, '/artists');
  }

  getOneById(id: string): Observable<Artist> {
    return this.apiService.getOneById(id);
  }

  getMany(params): Observable<Artist[]> {
    return this.apiService.getMany(params)
      .map(data => data.artists);
  }
}
