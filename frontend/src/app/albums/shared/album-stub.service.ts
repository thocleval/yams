import { ALBUMS } from './../../mock-albums';
import { Album } from './album';

export const albumStubService = {

  getOneById(id: string): Promise<Album> {
    console.log(id);
    return this.getMany()
      .then(albums => albums.find(album => album.id === id));
  },

  getMany(): Promise<Album[]> {
    return Promise.resolve(ALBUMS);
  },

  getManyByArtist(artistId): Promise<Album[]> {
    return this.getMany();
  },
};
