import { Album } from './../../albums/shared/album';

export class Artist {
  constructor(
    public id: string,
    public name: string,
    public biography: string,
    public avatar: string,
    public cover: string,
    public likeCount: number,
    public albums?: Album[],
    public featuredAlbums?: Album[],
  ) {  }
}
