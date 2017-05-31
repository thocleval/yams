import { ArtistService } from './../../artists/shared/artist.service';
import { TrackService } from './../../tracks/shared/track.service';
import { AlbumService } from './../shared/album.service';
import { Album } from './../shared/album';
import { ActivatedRoute, Params } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import 'rxjs/add/operator/switchMap';

@Component({
  selector: 'app-album-detail',
  templateUrl: './album-detail.component.html',
  styleUrls: ['./album-detail.component.scss'],
  providers: [
    AlbumService,
    TrackService,
    ArtistService,
  ],
})
export class AlbumDetailComponent implements OnInit {
  private album: Album;

  constructor(
    private route: ActivatedRoute,
    private albumService: AlbumService,
    private trackService: TrackService,
    private artistService: ArtistService
  ) { }

  ngOnInit() {
    this.albumService.getOneById(this.route.snapshot.params['albumId'])
      .then(album => {
        this.album = album;
        return Promise.all([
          this.artistService.getOneById(this.route.snapshot.params['artistId']),
          this.trackService.getManyByAlbum(this.album.id),
        ]);
      })
      .then(([artist, tracks]) => {
        this.album.artist = artist;
        this.album.tracks = tracks;
        console.log(tracks, artist)
      });
  }

  onFavClick() {

  }

  onPlayedClick() {
    for (const track of this.album.tracks) {
      track.played = true;
    }
  }
}
