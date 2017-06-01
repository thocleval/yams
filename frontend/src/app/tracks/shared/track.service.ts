import { ApiHelperService } from './../../shared/api-helper.service';
import { Http } from '@angular/http';
import { Track } from './track';
import { Injectable } from '@angular/core';

import 'rxjs/add/operator/toPromise';


@Injectable()
export class TrackService extends ApiHelperService {
  apiUrl = 'tracks/';

  constructor(http: Http) {
    super(http);
  }

  getOneById(id: string): Promise<Track> {
    return this.get(this.apiUrl + id);
  }

  getMany(params = {}): Promise<Track[]> {
    return this.get(this.apiUrl, params)
      .then(data => data._embedded.tracks)
      .catch(error => console.error(error));
  }


  getManyByAlbum(albumId): Promise<Track[]> {
    return this.get('/albums/' + albumId + '/' + this.apiUrl)
      .then(data => data._embedded.tracks)
      .catch(error => console.error(error));
  }
}
