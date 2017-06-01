import { ApiHelperService } from './../../shared/api-helper.service';
import { Http } from '@angular/http';
import { Album } from './album';
import { Injectable } from '@angular/core';


@Injectable()
export class AlbumService extends ApiHelperService {
  apiUrl = 'albums/';

  constructor(http: Http) {
    super(http);
  }

  getOneById(id: string): Promise<Album> {
    return this.get(this.apiUrl + id)
      .catch(error => console.error(error));
  }

  getMany(params = {}): Promise<Album[]> {
    return this.get(this.apiUrl, params)
      .then(data => data._embedded.albums)
      .catch(error => console.error(error));
  }

  getManyByArtist(artistId): Promise<Album[]> {
    return this.get('/artists/' + artistId + '/' + this.apiUrl)
      .then(data => data._embedded.albums)
      .catch(error => console.error(error));
  }
}
