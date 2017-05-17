import { ALBUMS } from './../../mock-albums';
import { Album } from './album';
import { Injectable } from '@angular/core';

import 'rxjs/add/operator/toPromise';


@Injectable()
export class AlbumService {
  albumsUrl = 'api/album/';

  constructor() { }

  getAlbumById(id: string): Promise<Album> {
    console.log(id);
    return this.getAlbums()
      .then(albums => albums.find(album => album.id === id));
  }

  getAlbums(): Promise<Album[]> {
    // return this.http.get(this.albumsUrl)
    //            .toPromise()
    //            .then(response => response.json().data as album[])
    //            .catch(this.handleError);
    return Promise.resolve(ALBUMS);
  }
  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

}
