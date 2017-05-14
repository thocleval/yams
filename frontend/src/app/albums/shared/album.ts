import { Track } from './../../tracks/shared/track';
import { Artist } from './../../artists/shared/artist';
import { Style } from './../../models/style';

export class Album {
  constructor(
    public id: string,
    public name: string,
    public coverPicture: string,
    public duration: number,
    public styles: Style[],
    public tracks: Track[],
    public likeCount: number,
    public artist?: Artist,
    public releaseDate?: Date,
    public link?: string,
    public mainArtist?: Artist,
    public featArtists?: Artist[],
  ) {  }
}
