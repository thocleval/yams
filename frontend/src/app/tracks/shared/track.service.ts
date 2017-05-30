import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { ApiService } from './../../shared/api.service';
import { Track } from './track';
import { Injectable } from '@angular/core';

import { ApiInterface } from '../../shared/api-interface';

import 'rxjs/add/operator/toPromise';


@Injectable()
export class TrackService implements ApiInterface<Track> {
  tracksUrl = 'api/track/';
  private apiService: ApiService<Track>;

  constructor(http: Http) {
    this.apiService = new ApiService(http, '/tracks');
  }

  getOneById(id: string): Observable<Track> {
    return this.apiService.getOneById(id);
  }

  getMany(params): Observable<Track[]> {
    return this.apiService.getMany(params)
      .map(data => data.tracks);
  }
}
