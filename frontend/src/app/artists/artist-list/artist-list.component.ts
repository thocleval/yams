import { ArtistService } from './../shared/artist.service';
import { Artist } from './../shared/artist';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-artist-list',
  templateUrl: './artist-list.component.html',
  styleUrls: ['./artist-list.component.scss'],
})
export class ArtistListComponent implements OnInit {

  @Input() artists: Artist[];

  constructor() { }

  ngOnInit() {

  }

}
