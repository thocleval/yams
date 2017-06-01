import { TRACKS } from './../../mock-tracks';
import { Track } from './track';

export const trackStubService = {

  getOneById(id: string): Track {
    return this.getMany()
      .then(tracks => tracks.find(track => track.id === id));
  },

  getMany(params = {}): Promise<Track[]> {
    return Promise.resolve(TRACKS);
  },

  getManyByAlbum(albumId): Promise<Track[]> {
    return this.getMany();
  },
};
