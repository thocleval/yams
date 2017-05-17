import { ArtistService } from './../shared/artist.service';
import { Artist } from './../shared/artist';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-artists-page',
  templateUrl: './artists-page.component.html',
  styleUrls: ['./artists-page.component.scss'],
  providers: [ArtistService]
})
export class ArtistsPageComponent implements OnInit {


  private artists: Artist[];

  constructor(
    private service: ArtistService
  ) { }

  ngOnInit() {
      this.service.getArtists().then(artists => this.artists = artists);
  }

}
