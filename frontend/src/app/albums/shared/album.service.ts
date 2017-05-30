import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { ApiService } from './../../shared/api.service';
import { Album } from './album';
import { Injectable } from '@angular/core';

import { ApiInterface } from '../../shared/api-interface';

import 'rxjs/add/operator/toPromise';


@Injectable()
export class AlbumService implements ApiInterface<Album> {
  albumsUrl = 'api/album/';
  private apiService: ApiService<Album>;

  constructor(http: Http) {
    this.apiService = new ApiService(http, '/albums');
  }

  getOneById(id: string): Observable<Album> {
    return this.apiService.getOneById(id);
  }

  getMany(params): Observable<Album[]> {
    return this.apiService.getMany(params)
      .map(data => {
        console.log(data);
        return data.albums;
      });
  }
}
