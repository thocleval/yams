import { AlbumService } from './../../albums/shared/album.service';
import { Album } from './../../albums/shared/album';
import { Http } from '@angular/http';
import { ArtistService } from './../shared/artist.service';
import { Artist } from './../shared/artist';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import 'rxjs/add/operator/switchMap';

@Component({
  selector: 'app-artist-detail',
  templateUrl: './artist-detail.component.html',
  styleUrls: ['./artist-detail.component.scss'],
  providers: [
    ArtistService,
    AlbumService
  ],
})
export class ArtistDetailComponent implements OnInit {

  private artist: Artist;

  constructor(
    private route: ActivatedRoute,
    private artistService: ArtistService,
    private albumService: AlbumService,
  ) { }

  ngOnInit() {
    this.route.params
      // (+) converts string 'id' to a number
      .switchMap((params: Params) => this.artistService.getOneById(params['artistId']))
      .subscribe((artist: Artist) => {
        this.artist = artist;
        return this.albumService.getManyByArtist(this.artist.id)
          .then(albums => {
            this.artist.albums = albums;
          });
      });
  }

}
