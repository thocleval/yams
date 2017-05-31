import { ApiHelperService } from './../../shared/api-helper.service';
import { Http } from '@angular/http';
import { Artist } from './artist';
import { Injectable } from '@angular/core';

import 'rxjs/add/operator/toPromise';


@Injectable()
export class ArtistService extends ApiHelperService {
  apiUrl = 'artists/';

  constructor(http: Http) {
    super(http);
  }

  getOneById(id: string): Promise<Artist> {
    return this.get(this.apiUrl + id)
      .catch(error => console.error(error));;
  }

  getMany(params = {}): Promise<Artist[]> {
    return this.get(this.apiUrl, params)
      .then(data => data._embedded.artists)
      .catch(error => console.error(error));
  }
}
