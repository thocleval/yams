import { ARTISTS } from './../../mock-artists';
import { Artist } from './artist';
import { Injectable } from '@angular/core';

import 'rxjs/add/operator/toPromise';


@Injectable()
export class ArtistService {
  artistsUrl = 'api/artist/';

  constructor() { }

  getArtistById(id: string): Promise<Artist> {
    return this.getArtists()
      .then(artists => artists.find(artist => artist.id === id));
  }

  getArtists(): Promise<Artist[]> {
    // return this.http.get(this.artistsUrl)
    //            .toPromise()
    //            .then(response => response.json().data as Artist[])
    //            .catch(this.handleError);
    return Promise.resolve(ARTISTS);
  }
  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

}
