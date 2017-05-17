import { ArtistService } from './../shared/artist.service';
import { Artist } from './../shared/artist';
import { Router, ActivatedRoute, Params } from '@angular/router';

import { Component, OnInit } from '@angular/core';
import 'rxjs/add/operator/switchMap';

@Component({
  selector: 'app-artist-detail',
  templateUrl: './artist-detail.component.html',
  styleUrls: ['./artist-detail.component.scss'],
  providers: [ArtistService],
})
export class ArtistDetailComponent implements OnInit {

  private artist: Artist;

  constructor(
    private route: ActivatedRoute,
    private service: ArtistService,
  ) { }

  ngOnInit() {
    this.route.params
      // (+) converts string 'id' to a number
      .switchMap((params: Params) => this.service.getArtistById(params['id']))
      .subscribe((artist: Artist) => this.artist = artist);
  }

}
