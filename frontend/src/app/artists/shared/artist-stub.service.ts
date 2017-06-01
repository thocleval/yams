import { ARTISTS } from './../../mock-artists';
import { Artist } from './artist';

export const artistStubService = {

  getOneById(id: string): Promise<Artist> {
    return this.getMany()
      .then(artists => artists.find(artist => artist.id === id));
  },

  getMany(): Promise<Artist[]> {
    return Promise.resolve(ARTISTS);
  },
};
